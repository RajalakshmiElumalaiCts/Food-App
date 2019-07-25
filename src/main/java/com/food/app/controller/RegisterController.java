package com.food.app.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.food.app.SingletonBCryptEncoder;
import com.food.app.model.User;
import com.food.app.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/food-api/user")
public class RegisterController {
	private static final Logger LOGGER = LogManager.getLogger(RegisterController.class);
	
	@Autowired
	public UserService userService;
	
	@PutMapping(value = "/add")
	public  ResponseEntity<String> registerUser(@RequestBody User user) {

		  try {
			  String encodedPassword = SingletonBCryptEncoder.passwordEncoder().encode(user.getPassword());
			  user.setPassword(encodedPassword);
			  user =  userService.addUser(user);

			 LOGGER.info("New user added to USER table :"+ user);
		  }catch(Exception ex) {
			  LOGGER.error("Unable to add new user", ex);
			  return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).
					  body("Registration Unsuccess " + user.getFirstname() +"!!!");
		  }
		  
		  return ResponseEntity.status(HttpStatus.OK).
				  body("Registration success " + user.getFirstname() +"!!!");
			
	  }

}
