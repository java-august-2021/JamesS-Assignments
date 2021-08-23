package com.jamesgabbie.dojosurvey.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String index() {
		
		return "index.jsp";
	}
	
	@RequestMapping(value="/results", method=RequestMethod.POST)	
		public String results(
			@RequestParam("name")String name,
			@RequestParam("location")String location,
			@RequestParam("fav_language")String favLanguage,
			@RequestParam("comment")String comment, Model viewModel){
			viewModel.addAttribute("name", name);
			viewModel.addAttribute("location", location);
			viewModel.addAttribute("favLanguage", favLanguage);
			viewModel.addAttribute("comment", comment);
		
		
			return "results.jsp";
		}
	

}
