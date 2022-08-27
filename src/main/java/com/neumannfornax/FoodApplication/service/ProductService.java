package com.neumannfornax.FoodApplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neumannfornax.FoodApplication.dao.ProductDao;
import com.neumannfornax.FoodApplication.dto.Product;


@Service
public class ProductService {
	
	@Autowired
	ProductDao productDao;
	
	public Product saveProduct(Product product) {
		return productDao.saveProduct(product);
	}
	
	public List<Product> getAllProducts(){
		return productDao.getAllProducts();
	}
	
	public Product getProductById( int id){
		return productDao.getProductById(id);
	}
	
	public Product updateProductById( Product product ,  int id){
		return productDao.updateProductById(product, id);
	}
	
	public String deleteProductById( int id){
		return productDao.deleteProductById(id);
	}
}