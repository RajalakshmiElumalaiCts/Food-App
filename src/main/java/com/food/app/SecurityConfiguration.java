package com.food.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Handles Spring Security
 *
 */
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	private static final String LOGIN = "/login";
	

	@Autowired
	UserDetailsService userDetailsService;

	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService);
		authProvider.setPasswordEncoder(SingletonBCryptEncoder.passwordEncoder());
		return authProvider;
	}	
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {		
		System.out.println("Hellooooooooooooooooo");
		  http
		  .cors().and()
		  .httpBasic() .and() .authorizeRequests().antMatchers(LOGIN, "/**").permitAll()
		  .anyRequest().authenticated()
		  .and()
		  .csrf().disable();	
		
			
	}

	public static UserPrincipal getUserPrincipal() {
		UserPrincipal userPrincipal = null;
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(! (authentication instanceof AnonymousAuthenticationToken )) {
			userPrincipal = (UserPrincipal)authentication.getPrincipal();
		}
		return userPrincipal;
	}


	
	
	

}
