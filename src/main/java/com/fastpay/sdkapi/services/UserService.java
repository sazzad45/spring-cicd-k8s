package com.fastpay.sdkapi.services;

import com.fastpay.sdkapi.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fastpay.sdkapi.dao.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public User findById(Long id) {
		return this.userRepository.findByUserId(id);
	}
}
