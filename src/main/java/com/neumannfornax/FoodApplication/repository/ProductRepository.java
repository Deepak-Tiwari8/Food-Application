package com.neumannfornax.FoodApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neumannfornax.FoodApplication.dto.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}