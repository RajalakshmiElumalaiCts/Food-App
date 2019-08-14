package com.food.app.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.food.app.SecurityConfiguration;
import com.food.app.model.User;
import com.food.app.model.ui.Credential;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/food-api/user")
public class LoginController {
	
	private static final Logger LOGGER = LogManager.getLogger(LoginController.class);
	
	@PostMapping(value = "/login")
	
	public ResponseEntity<User> login(@RequestBody Credential loginCredential) {
		System.out.println("username -----------------"+ loginCredential.getUsername());
		System.out.println("password -----------------"+ loginCredential.getPassword());
		System.out.println("here-----------------"+ SecurityConfiguration.getUserPrincipal().getUser());
		
		return ResponseEntity.status(HttpStatus.OK)
				.body( SecurityConfiguration.getUserPrincipal().getUser() );
		
	}
	
}
