package com.neumannfornax.FoodApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neumannfornax.FoodApplication.dto.FoodOrder;

public interface FoodOrderRepository extends JpaRepository<FoodOrder, Integer> {

}