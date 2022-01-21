package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomerUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository ur;
	
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
		
		Users user = ur.findByEmail(email);
		if (user ==null) {
			throw new UsernameNotFoundException("UserNotFound");
		}
		
		return  new CustomerUserDetails(user);
		
	}

}
