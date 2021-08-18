package com.example.stringsAssignment.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	@RequestMapping("/")
	private String index() {
		return "Hello client!  How are you doing?";
	}
	@RequestMapping("/random")
	private String random() {
		return "Spring boot is great!  So easy to reply with strings!";
	}

}
