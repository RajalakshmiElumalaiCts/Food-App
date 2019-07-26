package com.food.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Handles Spring Security
 *
 */
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	private static final String LOGIN = "/login";
	private static final String LOGIN_PAGE = "/login";
	private static final String LOGOUT = "/logout";

	@Autowired
	UserDetailsService userDetailsService; 
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		
		  http
		  .cors().and()
		  .httpBasic() .and() .authorizeRequests().antMatchers(/*HttpMethod.PUT*/LOGIN, "/**").permitAll()
		  .anyRequest().authenticated() /* .and() .formLogin() */
		  .and()
		  .csrf().disable();
		
		
		/* http
			.csrf().disable()
			.authorizeRequests().antMatchers("/login").permitAll()
			.anyRequest().authenticated()
			.and()
			.formLogin()
			.loginPage("/login").permitAll()
			.and()
			.logout().invalidateHttpSession(true)
			.clearAuthentication(true)
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.logoutSuccessUrl("/logout-success").permitAll(); */
			
	}

	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(SingletonBCryptEncoder.passwordEncoder());
        return authProvider;
	}
		
}
