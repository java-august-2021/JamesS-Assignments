package com.jamesgabbie.dojosandninjas.controllers;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jamesgabbie.dojosandninjas.models.Dojo;
import com.jamesgabbie.dojosandninjas.models.Ninja;
import com.jamesgabbie.dojosandninjas.services.DojoService;
import com.jamesgabbie.dojosandninjas.services.NinjaService;

@Controller
public class DojoController {
	private DojoService dojoService;
	@Autowired
	private NinjaService ninjaService;

	
	public DojoController(DojoService dojoService) {
		this.dojoService = dojoService;
	}
	
	// JSP New Dojo
	@RequestMapping("/dojos/new")
	public String newDojo(@ModelAttribute("dojo")Dojo dojo) {
		return "newDojo.jsp";
	}
		
	// Create Dojo
	@PostMapping("/dojos/new")
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		this.dojoService.createDojo(dojo);
		System.out.println("New Dojo Created: " + dojo.getName());
		return "redirect:/dojos/new";
	}
	
	//JSP Display Dojo
	@RequestMapping("/dojos/{id}")
	public String displayDojo(@PathVariable("id") Long id, Dojo dojo, Model viewModel) {
		Dojo dojoToDisplay = this.dojoService.getOneDojo(id);
		List<Ninja> allNinjas = this.ninjaService.ninjasByDojo(dojoToDisplay);
		viewModel.addAttribute("allNinjas", allNinjas);
		viewModel.addAttribute("dojoToDisplay", dojoToDisplay);		
		return "display.jsp";
	}

	
	
	
	
}
