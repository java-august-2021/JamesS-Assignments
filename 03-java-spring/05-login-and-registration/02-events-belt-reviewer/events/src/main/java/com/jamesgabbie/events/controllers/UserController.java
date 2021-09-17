package com.jamesgabbie.events.controllers;


import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jamesgabbie.events.models.Event;
import com.jamesgabbie.events.models.Message;
import com.jamesgabbie.events.models.User;
import com.jamesgabbie.events.services.EventService;
import com.jamesgabbie.events.services.MessageService;
import com.jamesgabbie.events.services.UserService;

@Controller
public class UserController {
	private UserService uService;
	@Autowired
	private EventService eService;
	@Autowired
	private MessageService mService;
	public UserController(UserService uService) {
		this.uService = uService;
	}
	
	
	// JSP Login Page
	@GetMapping("/login")
	public String login(@ModelAttribute("user")User user) {
		return "loginPage.jsp";
	}
	
	//JSP Dashboard Page
	@GetMapping("/events")
	public String dashboard(@ModelAttribute("event")Event event,Model viewModel, HttpSession session) {
		//Verify Logged User
		if(session.getAttribute("user__id")==null) {
			return "redirect:/login";
		} else {
		Long userId = (Long)session.getAttribute("user__id");
		User loggedUser = this.uService.findUser(userId);
		viewModel.addAttribute("loggedUser", loggedUser);
		
		//Events by User
		List<Event> eventsByUser = eService.userEvents(loggedUser);
		viewModel.addAttribute("userEvents", eventsByUser);
		
		//Sort Events By State
		List<Event>eventsByState = this.eService.findEventByState(loggedUser.getState());
		List<Event>eventsNotInState = this.eService.findEventsNotInState(loggedUser.getState());
		viewModel.addAttribute("eventsInState", eventsByState);
		viewModel.addAttribute("eventsNotInState", eventsNotInState);
		
		//List of Joiners
	
			 	
				
		return "dashboard.jsp";
		
		
		
		}
	}
	
	
	//JSP Show Event
	@GetMapping("/events/{id}")
	public String showEvent(@ModelAttribute("message")Message message, @PathVariable("id")Long id, Model viewModel, HttpSession session) {
		if(session.getAttribute("user__id")==null) {
			return "redirect:/login";
		} else {
			Long userId = (Long)session.getAttribute("user__id");
			User loggedUser = this.uService.findUser(userId);
			viewModel.addAttribute("loggedUser", loggedUser);
			
			Event event = eService.findEvent(id);
			viewModel.addAttribute("event", event);
			
			List <User> allJoiners = event.getJoiners();
			viewModel.addAttribute("allJoiners", allJoiners);
			
			List<Message> allMessages = mService.findMessages(event);
			viewModel.addAttribute("allMessages", allMessages);

			return "showPage.jsp";
		}
		
	}
	
	
	//JSP Edit Event Page
	@GetMapping("/events/{id}/edit")
	public String viewEdit(@PathVariable("id")Long id, Model viewModel, HttpSession session) {
		if(session.getAttribute("user__id")==null) {
			return "redirect:/login";
		} else {
			Long userId = (Long)session.getAttribute("user__id");
			User loggedUser = this.uService.findUser(userId);
			
			Event event= eService.findEvent(id);
			
			
			if(event.getUser().equals(loggedUser)) {
				viewModel.addAttribute("event", event);
				return "editPage.jsp";
				
			} else {
				return "redirect:/logout";
			}
		
		
		}
		
		
	}
	
	/////////////////////////////////////////////////////////
	
	
	//POST Register
	@PostMapping("/registration")
	public String registerUser(@Valid @ModelAttribute("user")User user,
			BindingResult result, HttpSession session) {
		if(result.hasErrors()) {
			return "loginPage.jsp";
		} else {
			User newUser = uService.registerUser(user);
			session.setAttribute("user__id", newUser.getId());
			return "redirect:/events";
		}
	}
	
	
	//POST Login
	@PostMapping("/login")
	public String loginUser(@RequestParam("email")String email, 
							@RequestParam("password")String password, Model viewModel, 
							HttpSession session) {
		if(this.uService.authenticateUser(email, password) == true) {
			Long loggedId = this.uService.findByEmail(email).getId();
			session.setAttribute("user__id", loggedId);
			return "redirect:/events";
			
		} else {
			viewModel.addAttribute("error","*Invalid Username and Password*");
			return "loginPage.jsp";
		}
	}
	
	//Create Event
	@PostMapping("/events/create")
	public String createEvent(@Valid @ModelAttribute("event")Event event, BindingResult result, HttpSession session) {
		Long userId = (Long)session.getAttribute("user__id");
		User loggedUser = this.uService.findUser(userId);
		
		if(result.hasErrors()) {
			return "dashboard.jsp";
		}else {
			event.setUser(loggedUser);
			eService.createEvent(event);
			return "redirect:/events";
		}
	}
	
	//Edit Event
	@PutMapping("/events/edit/{id}")
	public String editEvent(@Valid @ModelAttribute ("event")Event event, BindingResult result, HttpSession session) {
		Long userId = (Long)session.getAttribute("user__id");
		User loggedUser = this.uService.findUser(userId);
		if(result.hasErrors()) {
			return "editPage.jsp";
		}else {
			event.setUser(loggedUser);
			eService.updateEvent(event);
			return "redirect:/events";
		}
		
	}
	
	
	//Add Joiner
	@GetMapping("/events/join/{id}")
	public String like(@PathVariable("id")Long id, HttpSession session) {
		Long userId = (Long) session.getAttribute("user__id");
		Long eventId = id;
		User joiner = this.uService.findUser(userId);
		Event joinedEvent = this.eService.findEvent(eventId);
		this.eService.addJoiner(joinedEvent, joiner);
		return "redirect:/events";
		
	}
	
	//Cancel Joining
	@GetMapping("events/cancel/{id}")
	public String cancel(@PathVariable("id")Long id, HttpSession session) {
		Long userId = (Long) session.getAttribute("user__id");
		Long eventId = id;
		User joiner = this.uService.findUser(userId);
		Event joinedEvent = this.eService.findEvent(eventId);
		this.eService.removeJoiner(joinedEvent, joiner);
		
		return "redirect:/events";
	}
	
	//Create Message
	@PostMapping("/events/message/create/{id}")
	public String createEvent(@PathVariable("id")Long id,@RequestParam("message")String message, HttpSession session) {
		Long userId = (Long)session.getAttribute("user__id");
		User loggedUser = this.uService.findUser(userId);
		
		Event event = eService.findEvent(id);
		
		Message newMessage = new Message(message, loggedUser, event);
		mService.createMessage(newMessage);
		
		return "redirect:/events/{id}";
	}
	
	//Logout
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}

}
