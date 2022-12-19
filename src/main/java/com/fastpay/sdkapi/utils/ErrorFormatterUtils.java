package com.fastpay.sdkapi.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.Errors;

public class ErrorFormatterUtils {
	
	public static List<String> convertFieldErrorsToArrayList(Errors errors) {
		
		List<String> validationErrors = new ArrayList<>();
		errors.getFieldErrors().forEach((error) -> {
			validationErrors.add(error.getField() + " " + error.getDefaultMessage());
		});
		
		return validationErrors;
	}
}
