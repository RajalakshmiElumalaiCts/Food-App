package com.food.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.food.app.model.Order;


public interface OrderRepository extends CrudRepository<Order, Integer> {

}
