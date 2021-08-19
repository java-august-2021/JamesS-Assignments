package com.jamesgabbie.hellohuman.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

//	**** Without the use of jsp.file ****
		
//	@RequestMapping("/")
//	public String index(@RequestParam(value = "name", defaultValue = "Human",required = false)String name, Model model) {
//			return "Hello " + name;
//		
//	}
	
	
	@RequestMapping("/")
	public String index(@RequestParam(value = "name", defaultValue = "Human",required = false)String name, Model model) {
		model.addAttribute("name", name);
		return "index.jsp";
		
	}
	
}
