package com.sushant.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sushant.model.User;
import com.sushant.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User FindByEmail(String email) {
		return this.userRepository.findByEmail(email);
		
	}

	public Object save(@Valid User user) {
		return this.userRepository.save(user);
		
	}
	
}
