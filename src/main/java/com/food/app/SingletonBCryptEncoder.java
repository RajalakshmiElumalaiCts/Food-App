package com.food.app;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SingletonBCryptEncoder {
	
	//password encoding process taken for 7 rounds. default value is 10
	private static final BCryptPasswordEncoder pwdEncoder =  new BCryptPasswordEncoder(7);
	
	//private constructor.
    private SingletonBCryptEncoder(){}
	
	public static final BCryptPasswordEncoder passwordEncoder() {		
		return pwdEncoder;		
	}

}
