package com.jamesgabbie.languages.controllers;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jamesgabbie.languages.models.Language;
import com.jamesgabbie.languages.services.LanguageService;

@Controller
@RequestMapping("/languages")
public class HomeController {
	@Autowired
	private LanguageService service;
		
	
	//View Index.jsp 
	@GetMapping("")
	public String index(@ModelAttribute("language") Language language,  Model viewModel) {
		List<Language> allTheLanguages = service.getAll();
		viewModel.addAttribute("allTheLanguages", allTheLanguages);
		 
		return "index.jsp"; 
	}
	
	//View Edit.jsp
	@GetMapping("/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model viewModel) {
		Language language = service.getOne(id);
		viewModel.addAttribute("language", language);
		return "edit.jsp";
	}
	
	//View Display.jsp
	@GetMapping("/{id}")
	public String display(@PathVariable("id")Long id, Model viewModel) {
		Language language = service.getOne(id);
		viewModel.addAttribute("language", language);
		return "display.jsp";
	}
	
	//Create Language
	@PostMapping("")
	public String addLanguage(@Valid @ModelAttribute("language") Language language, BindingResult result) {
		if(result.hasErrors()) {
			return "index.jsp";
		}
		this.service.create(language);
		return "redirect:/languages";
	}
	
	//Update Language
	@RequestMapping(value="/{id}", method=RequestMethod.POST)
	public String update(@Valid @ModelAttribute("language") Language language, BindingResult result) {
		if(result.hasErrors()) {
			return "edit.jsp";
		}  else {
			service.update(language);
			return "redirect:/languages";
		}
		
	}
	
	//Delete Language
	@RequestMapping(value="/{id}/delete", method=RequestMethod.POST)
	public String destroy (@PathVariable("id")Long id) {
		service.deleteById(id);
		return "redirect:/languages";
	}
	
	
	
	
	
	
}
