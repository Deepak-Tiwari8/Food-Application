package com.neumannfornax.FoodApplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.neumannfornax.FoodApplication.dao.UserDao;
import com.neumannfornax.FoodApplication.dto.Login;
import com.neumannfornax.FoodApplication.dto.ResponseStructure;
import com.neumannfornax.FoodApplication.dto.User;

@Service
public class UserService {

	@Autowired
	UserDao userDao;

	public ResponseStructure<User> saveUser(User user) {
		ResponseStructure<User> responseStructure = new ResponseStructure<User>();
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Success");
		responseStructure.setData(userDao.saveUser(user));
		return responseStructure;
	}

	public ResponseStructure<User> getUserById(int id) {
 		User user = userDao.getUserById(id);
 		ResponseStructure<User> responseStructure = new ResponseStructure<User>();
 		if (user != null) {
 			responseStructure.setStatusCode(HttpStatus.OK.value());
 			responseStructure.setMessage("success");
 			responseStructure.setData(user);

 		} else {
 			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
 			responseStructure.setMessage("User Id Does not exist");
 			responseStructure.setData(null);

 		}
 		return responseStructure;
 	}
	public ResponseStructure<List<User>> getAllUsers() {
		List<User> user = userDao.getAllUsers();
		ResponseStructure<List<User>> responseStructure = new ResponseStructure<List<User>>();
		if(user!=null)
		{
			responseStructure.setStatusCode(HttpStatus.OK.value());
 			responseStructure.setMessage("success");
 			responseStructure.setData(user);
		}
		 else {
	 			responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
	 			responseStructure.setMessage("No User exist");
	 			responseStructure.setData(null);

	 		}
	 		return responseStructure;
		
	}

	public User updateUserById(User user, int id) {
		return userDao.updateUserById(user, id);
	}

	public String deleteUserById(int id) {
		return userDao.deleteUserById(id);
	}

	public User validateUser(Login login) {
		return userDao.validateUser(login);
	}
}