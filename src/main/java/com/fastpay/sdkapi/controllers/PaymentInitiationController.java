package com.fastpay.sdkapi.controllers;

import com.fastpay.sdkapi.dto.initiation.PaymentInitiationRequest;
import com.fastpay.sdkapi.dto.initiation.PaymentInitiationResponse;
import com.fastpay.sdkapi.exceptions.NonUniqueOrderIDException;
import com.fastpay.sdkapi.exceptions.StoreIdAndStorePasswordCombinationDidNotMatchException;
import com.fastpay.sdkapi.services.StoreConfigurationService;
import com.fastpay.sdkapi.services.UserService;
import com.fastpay.sdkapi.dto.ApiResponse;
import com.fastpay.sdkapi.entities.StoreConfiguration;
import com.fastpay.sdkapi.entities.User;
import com.fastpay.sdkapi.services.BcryptPasswordMatcherService;
import com.fastpay.sdkapi.services.PaymentInitiationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/api/v1/public/sdk/payment/initiation")
public class PaymentInitiationController {

	@Autowired
	BcryptPasswordMatcherService bcryptPasswordMatcherService;

	@Autowired
	StoreConfigurationService storeConfigurationService;

	@Autowired
	PaymentInitiationService paymentInitiationService;
	
	@Autowired
	UserService userService;

	@PostMapping(consumes = "application/json")
	public ResponseEntity<ApiResponse> initiatePaymentToken(
			@Valid @RequestBody PaymentInitiationRequest paymentInitiationRequest) throws Exception {

		StoreConfiguration store = storeConfigurationService.findByStoreId(paymentInitiationRequest.getStoreId());

		if (!bcryptPasswordMatcherService.isValidPassword(paymentInitiationRequest.getStorePassword(),
				store.getStorePassword()))
			throw new StoreIdAndStorePasswordCombinationDidNotMatchException();

		if (!paymentInitiationService
				.findByUserIdAndOrderId(store.getBusinessId(), paymentInitiationRequest.getOrderId()).isEmpty())
			throw new NonUniqueOrderIDException();
		
		User user = this.userService.findById(store.getBusinessId());

		PaymentInitiationResponse paymentInitiationResponse = paymentInitiationService.generatePaymentToken(paymentInitiationRequest, store, user);

		return new ResponseEntity<>(new ApiResponse("Payment Initiated", paymentInitiationResponse), HttpStatus.OK);
	}


}
