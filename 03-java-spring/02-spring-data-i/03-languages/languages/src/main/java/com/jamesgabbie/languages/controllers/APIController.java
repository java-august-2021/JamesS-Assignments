package com.jamesgabbie.languages.controllers;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.jamesgabbie.languages.services.LanguageService;

@RestController
@RequestMapping("/api")
public class APIController {
	private LanguageService service; 
	
	public APIController(LanguageService service) {
		this.service = service;
	}
	

}
