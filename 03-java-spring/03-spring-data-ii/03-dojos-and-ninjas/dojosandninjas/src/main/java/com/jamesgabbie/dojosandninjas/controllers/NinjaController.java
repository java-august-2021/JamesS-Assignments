package com.jamesgabbie.dojosandninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jamesgabbie.dojosandninjas.models.Dojo;
import com.jamesgabbie.dojosandninjas.models.Ninja;
import com.jamesgabbie.dojosandninjas.services.DojoService;
import com.jamesgabbie.dojosandninjas.services.NinjaService;

@Controller
public class NinjaController {
	private NinjaService ninjaService;
	@Autowired
	private DojoService dojoService;
	
	public NinjaController(NinjaService ninjaService) {
		this.ninjaService = ninjaService;
	}

	
	//JSP New Ninja
	@RequestMapping("/ninjas/new")
	public String newNinja(@ModelAttribute("ninja")Ninja ninja, Model viewModel) {
		List<Dojo> allDojos = this.dojoService.getAll();
		viewModel.addAttribute("allDojos", allDojos);
		return "newNinja.jsp";
	}
		
	//Create Ninja
	@PostMapping("/ninjas/new")
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
		this.ninjaService.createNinja(ninja);
		System.out.println("New Ninja Created: " + ninja);
		return "redirect:/ninjas/new";
	}
	

	
}
