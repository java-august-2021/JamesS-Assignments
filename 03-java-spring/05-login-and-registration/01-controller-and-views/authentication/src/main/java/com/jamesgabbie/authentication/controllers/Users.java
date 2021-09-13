package com.jamesgabbie.authentication.controllers;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jamesgabbie.authentication.models.User;
import com.jamesgabbie.authentication.services.UserService;

@Controller
public class Users {
	private final UserService uService;
	
	public Users(UserService uService) {
		this.uService = uService;
	}

	@GetMapping("/registration")
	public String registerForm(@ModelAttribute("user")User user) {
		return "registrationPage.jsp";
	}
	
	@GetMapping("/login")
	public String login() {
		return "loginPage.jsp";
	}
	
	@PostMapping("/registration")
	public String registerUser(@Valid @ModelAttribute("user")User user, BindingResult result, HttpSession session) {
		if(result.hasErrors()) {
			return "registrationPage.jsp";
		} else {
			User newUser = uService.registerUser(user);
			session.setAttribute("user__id", newUser.getId());
			return "redirect:/home";
		}
	}
	
	@PostMapping("/login")
	public String loginUser(@RequestParam("email")String email, 
					@RequestParam("password")String password, Model viewModel, 
					HttpSession session) {

		if(this.uService.authenticateUser(email, password) == true) {
			Long loggedId = this.uService.findByEmail(email).getId();
			session.setAttribute("user__id", loggedId);
			return "redirect:/home";
			
		} else {
			viewModel.addAttribute("error","*Invalid Username and Password*");
			return "loginPage.jsp";
		}
	}
	
	@GetMapping("/home")
	public String home(HttpSession session, Model viewModel) {
		if(session==null) {
			return "redirect:/login";
		} else {
		Long userId = (Long)session.getAttribute("user__id");
		User loggedUser = this.uService.findUserById(userId);
		viewModel.addAttribute("loggedUser", loggedUser);
		return "homePage.jsp";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}
	
}
