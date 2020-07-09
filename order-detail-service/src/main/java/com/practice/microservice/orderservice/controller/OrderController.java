package com.practice.microservice.orderservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.microservice.orderservice.entity.Order;
import com.practice.microservice.orderservice.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	OrderService service;
	
	@RequestMapping("/{userId}")
	public List<Order> orderById(@PathVariable(name = "userId")String userId){
		if(null == userId) return null;
		return service.orderByUserId(userId);
	}
	
	@RequestMapping("/order")
	public String sayHello() {
		return "Hello From Order Service";
	}
}
