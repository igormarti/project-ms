package com.imr.hroauth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.imr.hroauth.entities.User;
import com.imr.hroauth.feignclients.UserFeignClients;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserFeignClients clients;
	
	public User findByEmail(String email) {
		User user = clients.findByEmail(email).getBody();
		
		if(user==null) {
			throw new IllegalArgumentException("User not found");
		}
		
		return user;
	}

	@Override
	public UserDetails loadUserByUsername(String email) {
		User user = clients.findByEmail(email).getBody();
		
		if(user==null) {
			throw new UsernameNotFoundException("User not found");
		}
		
		return user;
	}
	
}
