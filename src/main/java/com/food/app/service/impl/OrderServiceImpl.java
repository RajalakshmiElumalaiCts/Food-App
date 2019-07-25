package com.food.app.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.food.app.model.Order;
import com.food.app.repository.OrderRepository;
import com.food.app.service.OrderService;

public class OrderServiceImpl implements OrderService {

	private static final Logger LOGGER = LogManager.getLogger(OrderServiceImpl.class);
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public Order saveOrder(Order order) {
		
		Order savedOrder = orderRepository.save(order);
		LOGGER.info("Order saved with ID : ",savedOrder.getId());
		return savedOrder;

	}
}
