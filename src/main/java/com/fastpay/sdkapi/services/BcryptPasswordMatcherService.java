package com.fastpay.sdkapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class BcryptPasswordMatcherService {

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	public boolean isValidPassword(String plainStorePassword, String hashedStorePassword) {
		return bCryptPasswordEncoder.matches(plainStorePassword, hashedStorePassword);
	}

}
