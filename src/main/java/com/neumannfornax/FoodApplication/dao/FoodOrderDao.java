package com.neumannfornax.FoodApplication.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.neumannfornax.FoodApplication.dto.FoodOrder;
import com.neumannfornax.FoodApplication.repository.FoodOrderRepository;

@Repository
public class FoodOrderDao {
	@Autowired
	FoodOrderRepository foodOrderRepository;
	
	public FoodOrder saveFoodOrder(FoodOrder foodOrder) {
		return foodOrderRepository.save(foodOrder);
	}
	
	public List<FoodOrder> getAllFoodOrders(){
		return foodOrderRepository.findAll();
	}
	
	public FoodOrder getFoodOrderById( int id){
		Optional<FoodOrder> optional=foodOrderRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			return null;
		}
	}
	
	public FoodOrder updateFoodOrderById( FoodOrder foodOrder ,  int id){
		Optional<FoodOrder> optional=foodOrderRepository.findById(id);
		if(optional.isPresent()) {
			return foodOrderRepository.save(foodOrder);
		}else {
			return null;
		}
	}
	
	public String deleteFoodOrderById( int id){
		Optional<FoodOrder> optional=foodOrderRepository.findById(id);
		if(optional.isPresent()) {
			foodOrderRepository.delete(optional.get());
			return "Deleted";
		}else {
			return "No FoodOrder to delete";
		}
	}
}