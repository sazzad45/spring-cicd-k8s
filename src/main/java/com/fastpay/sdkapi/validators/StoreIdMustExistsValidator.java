package com.fastpay.sdkapi.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.fastpay.sdkapi.dao.StoreConfigurationRepository;
import com.fastpay.sdkapi.entities.StoreConfiguration;

public class StoreIdMustExistsValidator implements ConstraintValidator<StoreIdMustExists, String> {

	@Autowired
	StoreConfigurationRepository storeConfigurationRepository;

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		StoreConfiguration store = storeConfigurationRepository.findByStoreId(value);
		
		if (store == null)
			return false;
		
		return true;
	}

}
