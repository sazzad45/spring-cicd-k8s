package com.fastpay.sdkapi.validators;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = StoreIdMustExistsValidator.class)
public @interface StoreIdMustExists {

	String message() default "not found in the system";
	
	Class<?>[] groups() default{};
	
	Class<? extends Payload>[] payload() default{};
}
