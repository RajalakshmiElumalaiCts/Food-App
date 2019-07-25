package com.food.app.service.impl;

import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.app.model.User;
import com.food.app.repository.UserRepository;
import com.food.app.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	private static final Logger LOGGER = LogManager.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User addUser(User user) {
		User saveduser = userRepository.save(user);
		LOGGER.info("New User added with ID : "+ user.getId());
		return saveduser;
	}

	@Override
	public User login(String userName, String password) {
		
		User user = userRepository.findByUsername(userName);
		
		if(user!= null && userName.equals(user.getUsername()) && password.equals(user.getPassword())) {
			LOGGER.info("Login successful for the user : ",userName);
			return user;
		}else
			LOGGER.info("Login failed for the user : ",userName);
			return null;		
	}
	

}
