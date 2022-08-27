package com.neumannfornax.FoodApplication.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.neumannfornax.FoodApplication.dto.Login;
import com.neumannfornax.FoodApplication.dto.User;
import com.neumannfornax.FoodApplication.repository.UserRepository;

@Repository
public class UserDao {

	@Autowired
	UserRepository userRepository;

	public User saveUser(User user) {
		return userRepository.save(user);
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User getUserById(int id) {
		Optional<User> optional = userRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}

	public User updateUserById(User user, int id) {
		Optional<User> optional = userRepository.findById(id);
		if (optional.isPresent()) {
			return userRepository.save(user);
		} else {
			return null;
		}
	}

	public String deleteUserById(int id) {
		Optional<User> optional = userRepository.findById(id);
		if (optional.isPresent()) {
			userRepository.delete(optional.get());
			return "Deleted";
		} else {
			return "No User to delete";
		}
	}

	public User validateUser(Login login) {
		String email = login.getUserEmail();
		String password = login.getUserPassword();
		User user = userRepository.validateUser(email, password);
		if (user != null) {
			return user;
		} else {
			return null;
		}
	}
}