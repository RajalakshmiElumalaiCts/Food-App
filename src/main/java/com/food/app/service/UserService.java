package com.food.app.service;

import com.food.app.model.User;

public interface UserService {
	
	User addUser(User user);

	User login(String userName, String password);

}
