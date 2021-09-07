package com.jamesgabbie.pac.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jamesgabbie.pac.models.Category;
import com.jamesgabbie.pac.models.Product;
import com.jamesgabbie.pac.repositories.CategoryRepository;
import com.jamesgabbie.pac.repositories.ProductRepository;

@Service
public class CategoryService {
	private CategoryRepository cRepo;
	@Autowired
	private ProductRepository pRepo;
	public CategoryService(CategoryRepository cRepo) {
		this.cRepo = cRepo;
	}
	
	
	//Create
	public Category createCategory(Category category) {
		return this.cRepo.save(category);
	}
	
	//Find Category by ID
	public Category findCategory(Long id) {
		Optional<Category> optionalCategory = cRepo.findById(id);
		if(optionalCategory.isPresent()) {
			return optionalCategory.get();
		} else { 
			return null;
		}
	}
	
	//FindAllCategories
	public List<Category> allCategories(){
		return cRepo.findAll();
	}
	
	//List of available products to a category
	public List<Product> availableProducts(Category category) {
		return pRepo.findByCategoriesNotContains(category);
	}
	
	//Add product to category
	public void addProductToCategory(Category category, Product product) {
		List<Product> productsOfCategory = category.getProducts();
		productsOfCategory.add(product);			
		this.cRepo.save(category);
		
		
		
		
		
		
		
		
		
	}
}

