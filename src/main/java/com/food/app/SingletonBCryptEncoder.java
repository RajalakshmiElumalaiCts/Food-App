package com.food.app;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Encodes the password by BCrypt encoding policy before storing to database
 *
 */
public class SingletonBCryptEncoder {
	
	//password encoding process taken for 7 rounds. default value is 10
	private static final BCryptPasswordEncoder pwdEncoder =  new BCryptPasswordEncoder(7);
	
	//private constructor.
    private SingletonBCryptEncoder(){}
	
	public static final BCryptPasswordEncoder passwordEncoder() {		
		return pwdEncoder;		
	}

}
