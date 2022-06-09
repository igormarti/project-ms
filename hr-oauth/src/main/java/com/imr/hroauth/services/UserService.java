package com.imr.hroauth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imr.hroauth.entities.User;
import com.imr.hroauth.feignclients.UserFeignClients;

@Service
public class UserService {

	@Autowired
	private UserFeignClients clients;
	
	public User findByEmail(String email) {
		User user = clients.findByEmail(email).getBody();
		
		if(user==null) {
			throw new IllegalArgumentException("User not found");
		}
		
		return user;
	}
	
}
