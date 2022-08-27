package com.neumannfornax.FoodApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.neumannfornax.FoodApplication.dto.Product;
import com.neumannfornax.FoodApplication.service.ProductService;



@RestController
public class ProductController {
		
	@Autowired
	ProductService productService;
	
	@PostMapping("/products")
	public Product saveProduct(@RequestBody Product product) {
		return productService.saveProduct(product);
	}
	
	@GetMapping("/products")
	public List<Product> getAllProducts(){
		return productService.getAllProducts();
	}
	
	@GetMapping("/products/{id}")
	public Product getProductById(@PathVariable int id){
		return productService.getProductById(id);
	}
	
	@PutMapping("/products/{id}")
	public Product updateProductById(@RequestBody Product product , @PathVariable int id){
		return productService.updateProductById(product ,id);
	}
	
	@DeleteMapping("/products/{id}")
	public String deleteProductById(@PathVariable int id){
		return productService.deleteProductById(id);
	}
}