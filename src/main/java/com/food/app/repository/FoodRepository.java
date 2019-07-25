package com.food.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.food.app.model.FoodItem;

public interface FoodRepository extends CrudRepository<FoodItem, Integer> {

}
