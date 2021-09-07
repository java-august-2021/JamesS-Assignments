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
public class ProductController {
	private ProductService pService;
	@Autowired
	private CategoryService cService;

	public ProductController(ProductService pService) {
		this.pService = pService;
	}

	@GetMapping("/products/new")
	public String newProduct(@ModelAttribute("product")Product product) {
		return "newProduct.jsp";
	}
	
	@PostMapping("/products/new")
	public String createProduct(@Valid @ModelAttribute("product")Product product, BindingResult result) {
		if(result.hasErrors()) {
			return "newProduct.jsp";
		} else {
			pService.createProduct(product);
			return "redirect:/products/new";
		}
	}
	
	@GetMapping("products/{id}")
	public String viewProduct(@PathVariable("id")Long id, Category category, Model viewModel){
		Product productView = pService.findProduct(id);
 		viewModel.addAttribute("productView", productView);
 		List<Category> categoriesAvailable = pService.availableCategories(productView);
 		viewModel.addAttribute("categoriesAvailable", categoriesAvailable);
		return "viewProduct.jsp";
	}
	
	@PostMapping("products/add/{id}")
	public String addCategory(@PathVariable("id")Long id, @RequestParam("categories") Long categoryId) {
		Product productToUpdate = this.pService.findProduct(id);
		Category categoryToAdd = this.cService.findCategory(categoryId);
		pService.addCategoryToProduct(productToUpdate, categoryToAdd);
		return "redirect:/products/{id}";
	}
}
