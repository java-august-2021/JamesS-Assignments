package com.jamesgabbie.pac.controllers;

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
import org.springframework.web.bind.annotation.RequestParam;

import com.jamesgabbie.pac.models.Category;
import com.jamesgabbie.pac.models.Product;
import com.jamesgabbie.pac.services.CategoryService;
import com.jamesgabbie.pac.services.ProductService;

@Controller
public class CategoryController {
	private CategoryService cService;
	@Autowired
	private ProductService pService;
	public CategoryController(CategoryService cService) {
		this.cService = cService;
	}

	@GetMapping("/categories/new")
	public String newCategory (@ModelAttribute("category") Category category) {
		return "newCategory.jsp";
	}
	
	@PostMapping("/categories/new")
	public String createCategory (@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if(result.hasErrors()) {
			return "newCategory.jsp";
		} else {
			cService.createCategory(category);
			return "redirect:/categories/new";
		}
	}
		
	@GetMapping("/categories/{id}")
	public String viewCategory (@PathVariable("id")Long id, Product product, Model viewModel) {		
		Category categoryView = cService.findCategory(id);
		viewModel.addAttribute("categoryView", categoryView);		
		List<Product> productsAvailable = cService.availableProducts(categoryView);
		viewModel.addAttribute("productsAvailable", productsAvailable);
		return "viewCategory.jsp";
	}
	
	@PostMapping("/categories/add/{id}")
	public String addProduct(@PathVariable ("id")Long id, @RequestParam("products") Long productId) {
		Category categoryToUpdate = this.cService.findCategory(id);
		Product productToAdd = this.pService.findProduct(productId);
		cService.addProductToCategory(categoryToUpdate, productToAdd);
		return "redirect:/categories/{id}";
	}
	
}
