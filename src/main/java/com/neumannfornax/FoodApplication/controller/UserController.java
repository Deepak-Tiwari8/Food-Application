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

import com.neumannfornax.FoodApplication.dto.Login;
import com.neumannfornax.FoodApplication.dto.ResponseStructure;
import com.neumannfornax.FoodApplication.dto.User;
import com.neumannfornax.FoodApplication.service.UserService;



@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/users")
	public ResponseStructure<User> saveUser(@RequestBody User user) {
		return userService.saveUser(user);
	}

	@GetMapping("/users/{id}")
	public ResponseStructure<User> getUserById(@PathVariable int id) {
		return userService.getUserById(id);
	}

	
	@GetMapping("/users")
	public  ResponseStructure<List<User>> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@PutMapping("/users/{id}")
	public User updateUserById(@RequestBody User user , @PathVariable int id){
		return userService.updateUserById(user ,id);
	}
	
	@DeleteMapping("/users/{id}")
	public String deleteUserById(@PathVariable int id){
		return userService.deleteUserById(id);
	}
	
	@PostMapping("/users/login")
	public User validateUser(@RequestBody Login login) {
		return userService.validateUser(login);
	}
}