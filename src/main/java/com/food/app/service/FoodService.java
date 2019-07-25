package com.food.app.service;

import java.util.List;

import com.food.app.model.FoodItem;

public interface FoodService {
	
	List<FoodItem> fetchFoods();
	
	FoodItem saveFood(FoodItem food);
	
	void deleteFood(int foodID);

}
