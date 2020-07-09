package com.practice.microservice.aggregatorservice.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.practice.microservice.aggregatorservice.entity.Order;
import com.practice.microservice.aggregatorservice.entity.User;
import com.practice.microservice.aggregatorservice.entity.UserWithOrderDetails;

@RestController
public class AggregatorServiceCotroller {
	/*
	 * @Autowired private EurekaClient eurekaClient;
	 */
	@Autowired
	private RestTemplate restTemplate;

	@Value("${server.port}")
	private int port;

	@RequestMapping("/orderdetails/{userId}")
	public UserWithOrderDetails orderDetails(@PathVariable(name = "userId")String userId){
		System.out.println("Working from port " + port + " of AggregatorService");
		if(null == userId) return null;

		UserWithOrderDetails userOrderDetails = new UserWithOrderDetails();
		// calling userservice to get userdetails by id
		String url = "http://localhost:8070/user/" + userId;
		//InstanceInfo instance = eurekaClient.getNextServerFromEureka("userservice", false);
		User user = restTemplate.getForObject(url, User.class);
		System.out.println("User in aggregator service : "+ user);

		// calling Orderservice to get orders by userid
		if(null != user) {
			String orderurl = "http://localhost:8060/orders/" + userId;
			//instance = eurekaClient.getNextServerFromEureka("orderservice", false);
			ResponseEntity<Order[]> orderEntities = restTemplate.getForEntity(orderurl, Order[].class);

			if(orderEntities.hasBody() && null != orderEntities.getBody()) {
				List<Order> orders = Arrays.asList(orderEntities.getBody());
				userOrderDetails.setUser(user);
				userOrderDetails.setOrders(orders);
			}
		} 
		return userOrderDetails;
	}
	
	@RequestMapping("/orderdetail")
	public String sayHello() {
		return "Hello From Aggregator Service";
	}
}