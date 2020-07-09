package com.practice.microservice.userservice.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.microservice.userservice.entity.User;
import com.practice.microservice.userservice.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService userService;
	
	@RequestMapping("/user/{id}")
	public Optional<User> userById(@PathVariable(name = "id")String id) {
		if(null == id) return null;
		return userService.getUserById(id);
	}
	
	@RequestMapping("/user")
	public String sayHello() {
		return "Hello From User Service";
	}
}
