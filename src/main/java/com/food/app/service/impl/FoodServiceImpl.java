package com.food.app.service.impl;

import java.util.List;

import org.apache.commons.collections4.IteratorUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.food.app.model.FoodItem;
import com.food.app.repository.FoodRepository;
import com.food.app.service.FoodService;

public class FoodServiceImpl implements FoodService {

	private static final Logger LOGGER = LogManager.getLogger(FoodServiceImpl.class);
	
	@Autowired
	private FoodRepository foodRepository;
	
	@Override
	public List<FoodItem> fetchFoods() {
		Iterable<FoodItem> allFoodIterable= foodRepository.findAll();
		List<FoodItem> allFoods = IteratorUtils.toList(allFoodIterable.iterator());
		return allFoods;
	}

	@Override
	public FoodItem saveFood(FoodItem food) {
		FoodItem savedFood = foodRepository.save(food);
		LOGGER.info("FoodItem saved with ID : ",savedFood.getId());
		return savedFood;
	}

	@Override
	public void deleteFood(int foodID) {
		foodRepository.deleteById(foodID);
		LOGGER.info("FoodItem deleted with ID : ",foodID);
	}

}
