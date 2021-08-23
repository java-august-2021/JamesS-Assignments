package com.jamesgabbie.thecode.controllers;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



@Controller
public class HomeControllers {
	
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@PostMapping("/access")
	public String code(@RequestParam(value="input")String input){
		String secretCode = "bushido";
		if(input.equals(secretCode)) {
			return "code.jsp";
		}  else {
			return "redirect:/errors";
		}
	}
	
	@GetMapping("/errors")
	public String errors(RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("error", "You must try harder!");
		return "redirect:/";
	}
	
	
	
}
