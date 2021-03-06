package com.food.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.food.app.model.User;
import com.food.app.repository.UserRepository;

/**
 * Added part of Spring Security.Fetches user from database and returns as UserPrincipal,\
 * which will be handled by spring framework
 *
 */
@Service
public class SpringUserDetailsServiceImpl implements UserDetailsService {
;
	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new UserPrincipal(user);
	}

}
