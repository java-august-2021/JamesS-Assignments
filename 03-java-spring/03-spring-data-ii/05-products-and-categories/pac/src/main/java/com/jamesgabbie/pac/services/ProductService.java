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
public class ProductService {
	private ProductRepository pRepo;
	@Autowired
	private CategoryRepository cRepo;
	
	public ProductService(ProductRepository pRepo) {
		this.pRepo = pRepo;
	}

	//Create
	public Product createProduct(Product product) {
		return this.pRepo.save(product);
	}

	//Find Product by ID
	public Product findProduct(Long id) {
		Optional<Product> optionalProduct = pRepo.findById(id);
		if(optionalProduct.isPresent()) {
			return optionalProduct.get();
		} else {
			return null;
		}
	}
	
	//FindAllProducts
	public List <Product> allProducts(){
		return pRepo.findAll();
	}

	//List of available catagories to products
	public List<Category> availableCategories(Product product){
		return cRepo.findByProductsNotContains(product);
	}
	
	//Add category to product
	public void addCategoryToProduct(Product product, Category category) {
		List<Category> categoriesOfProducts = product.getCategories();
		categoriesOfProducts.add(category);
		this.pRepo.save(product);
	}
	
}

