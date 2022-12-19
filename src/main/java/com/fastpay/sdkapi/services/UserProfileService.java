package com.fastpay.sdkapi.services;

import com.fastpay.sdkapi.entities.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fastpay.sdkapi.dao.UserProfileRepository;

@Service
public class UserProfileService {
	
	@Autowired
	UserProfileRepository userProfileRepository;
	
	public UserProfile findByUserId(Long userId) {
		return this.userProfileRepository.findByUserId(userId);
	}
}
