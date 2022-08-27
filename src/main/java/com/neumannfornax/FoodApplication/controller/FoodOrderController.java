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

import com.neumannfornax.FoodApplication.dto.FoodOrder;
import com.neumannfornax.FoodApplication.service.FoodOrderService;



@RestController
public class FoodOrderController {
	
	@Autowired
	FoodOrderService foodOrderService;
	
	@PostMapping("/foodOrders")
	public FoodOrder saveFoodOrder(@RequestBody FoodOrder foodOrder) {
		return foodOrderService.saveFoodOrder(foodOrder);
	}
	
	@GetMapping("/foodOrders")
	public List<FoodOrder> getAllFoodOrders(){
		return foodOrderService.getAllFoodOrders();
	}
	
	@GetMapping("/foodOrders/{id}")
	public FoodOrder getFoodOrderById(@PathVariable int id){
		return foodOrderService.getFoodOrderById(id);
	}
	
	@PutMapping("/foodOrders/{id}")
	public FoodOrder updateFoodOrderById(@RequestBody FoodOrder foodOrder , @PathVariable int id){
		return foodOrderService.updateFoodOrderById(foodOrder ,id);
	}
	
	@DeleteMapping("/foodOrders/{id}")
	public String deleteFoodOrderById(@PathVariable int id){
		return foodOrderService.deleteFoodOrderById(id);
	}
}