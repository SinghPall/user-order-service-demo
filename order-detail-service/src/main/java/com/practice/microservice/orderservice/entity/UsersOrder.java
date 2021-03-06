package com.practice.microservice.orderservice.entity;

import java.util.List;

public class UsersOrder {
	private String userId;
	private List<Order> orders;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	@Override
	public String toString() {
		return "UsersOrder [userId=" + userId + ", orders=" + orders + "]";
	}
	
}
