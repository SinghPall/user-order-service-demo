package com.practice.microservice.orderservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.practice.microservice.orderservice.entity.Order;
import com.practice.microservice.orderservice.entity.UsersOrder;

@Service
public class OrderService {
	List<UsersOrder> userListWthOrder = new ArrayList<>();
	
	public List<Order> orderByUserId(String userId) {
		return getOrderByUserId(userId);
	}

	private List<Order> getOrderByUserId(String userId){
		loadData();
		
		Optional<UsersOrder> orders = userListWthOrder.stream().filter(e -> e.getUserId().equalsIgnoreCase(userId)).findAny();
		if(orders.isPresent())
			return orders.get().getOrders();
		return null;
	}
	
	private void loadData(){
		List<Order> orders = new ArrayList<>();
		Order order1 = new Order();
		order1.setOrderId("1001"); order1.setOrderAmount("3500"); order1.setOrderDate("14-May-2020");
		Order order2 = new Order();
		order2.setOrderId("1002"); order2.setOrderAmount("3300"); order2.setOrderDate("21-May-2020");
		Order order3 = new Order();
		order3.setOrderId("1003"); order3.setOrderAmount("2300"); order3.setOrderDate("01-May-2020");
		
		orders.add(order1);
		orders.add(order2);
		orders.add(order3);
		
		UsersOrder usersOrder = new UsersOrder();
		usersOrder.setUserId("101");
		usersOrder.setOrders(orders);
		userListWthOrder.add(usersOrder);
		/* 2nd user and its order list */
		List<Order> orders2 = new ArrayList<>();
		Order order4 = new Order();
		order4.setOrderId("1004"); order4.setOrderAmount("3800"); order4.setOrderDate("22-May-2020");
		Order order5 = new Order();
		order5.setOrderId("1005"); order5.setOrderAmount("6300"); order5.setOrderDate("11-May-2020");
		orders2.add(order4);
		orders2.add(order5);
		
		UsersOrder usersOrder2 = new UsersOrder();
		usersOrder2.setUserId("102");
		usersOrder2.setOrders(orders2);
		userListWthOrder.add(usersOrder2);
	}

}
