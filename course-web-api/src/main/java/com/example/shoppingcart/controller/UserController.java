package com.example.shoppingcart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.shoppingcart.repository.UserRepository;
import com.example.shoppingcart.model.User;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping(value = "/all")
	public List<User> getAll() {
		return userRepository.findAll();
	}
	
	@GetMapping(value = "/update/{id}/{name}/{phoneNumber}/{password}/{index}")
	public List<User> updateUser(
			@PathVariable final int id,
			@PathVariable final String name,
			@PathVariable final String phoneNumber,
			@PathVariable final String password,
			@PathVariable final String index
			) {
		userRepository.updateUser(id, name, phoneNumber, password, index);
		return userRepository.findAll();
		
	}
	
	@GetMapping(value = "/create/{name}/{phoneNumber}/{password}/{index}")
	public List<User> getCreateUser(
			@PathVariable final String name,
			@PathVariable final String phoneNumber,
			@PathVariable final String password,
			@PathVariable final String index
			) {
		
		User user = new User();
		user.setIndex(index);
		user.setPassword(password);
		user.setPhoneNumber(phoneNumber);
		user.setUserName(name);
		userRepository.createUser(name, phoneNumber, password, index);
		return userRepository.findAll();
		
	}
	
	@GetMapping(value = "/findById/{id}")
	public List<User> getUserById(@PathVariable final int id) {
		return userRepository.findById(id);
	}
	
	@GetMapping(value = "/findByIndex/{index}")
	public List<User> getUserByIndex(@PathVariable final String index) {
		return userRepository.findByIndex(index);
	}
	
}
