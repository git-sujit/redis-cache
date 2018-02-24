package com.sks.learn.rediscache.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sks.learn.rediscache.dao.UserRepository;
import com.sks.learn.rediscache.model.User;

@RestController
@RequestMapping("/redis")
public class UserController {
	@Autowired
	private UserRepository userRepository;

	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@GetMapping(value = "/users")
	public Map<String, User> allUsers() {
		return userRepository.findAll();
	}

	@PostMapping("/users")
	public void createUser(@RequestBody User user) {
		userRepository.save(user);
	}

	@PutMapping("/users")
	public void updateUser(@RequestBody User user) {
		userRepository.save(user);
	}

	@GetMapping(value = "/users/{id}")
	public User getUserById(@PathVariable String id) {
		return userRepository.findById(id);
	}

	@DeleteMapping(value = "/users/{id}")
	public void deleteUser(@PathVariable String id) {
		userRepository.delete(id);
	}

	public UserRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

}
