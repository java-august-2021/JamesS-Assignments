package com.jamesgabbie.counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String index(HttpSession session) {
		
		
		if(session.getAttribute("count")==null) {
			session.setAttribute("count", 1);
		}
		else {
			Integer visits = (Integer) session.getAttribute("count");
			session.setAttribute("count",visits+1);
		}
		return "index.jsp";
	}
	
	@RequestMapping("/counter")
	public String counter(HttpSession session, Model model) {
		Integer currentCount = (Integer) session.getAttribute("count");
		model.addAttribute("countToShow", currentCount);
		return "counter.jsp";
	}
	
	@RequestMapping("/reset")
	public String counterByTwo(HttpSession session) {
		session.setAttribute("count",1);
		return "index.jsp";
	}
	
	

}
