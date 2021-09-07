package com.jamesgabbie.pac.repositories;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jamesgabbie.pac.models.Category;
import com.jamesgabbie.pac.models.Product;


@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{

	//Find all Categories
	List<Product> findAll();
	
	// Retrieves a list of all products for a particular category
    List<Product> findAllByCategories(Category category);
    
    // Retrieves a list of any products available for a category
    List<Product> findByCategoriesNotContains(Category category);
	
}
