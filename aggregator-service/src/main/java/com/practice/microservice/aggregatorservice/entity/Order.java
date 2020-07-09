package com.practice.microservice.aggregatorservice.entity;

public class Order {
	private String orderId;
	private String orderAmount;
	private String orderDate;
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getOrderAmount() {
		return orderAmount;
	}
	public void setOrderAmount(String orderAmount) {
		this.orderAmount = orderAmount;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderAmount=" + orderAmount + ", orderDate=" + orderDate + "]";
	}
	
}
