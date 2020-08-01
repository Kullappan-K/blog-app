package com.blog.service.impl;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.blog.model.Users;
import com.blog.repository.UserRepository;

@Service
public class SecurityServiceImpl implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;
	
	private int userId; 

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Users> usersData = userRepository.findById(username);
		if(usersData.isPresent()) {
			Users users = usersData.get();
			userId = users.getUser_id();
			return new User(users.getUsername(), users.getPassword(), new ArrayList<>());
		}
		return null;
	}
	
	public int getUserId() {
		return userId;
	}
}
