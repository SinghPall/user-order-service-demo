package com.practice.microservice.userservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.microservice.userservice.dao.UserRepository;
import com.practice.microservice.userservice.entity.User;

@Service	
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	public Optional<User> getUserById(String id) {
		System.out.println("In service class");
		return userRepository.findById(id);
	}

}
