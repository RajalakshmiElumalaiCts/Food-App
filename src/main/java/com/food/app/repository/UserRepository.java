package com.food.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.food.app.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	
	User findByUsername(String username);
}
