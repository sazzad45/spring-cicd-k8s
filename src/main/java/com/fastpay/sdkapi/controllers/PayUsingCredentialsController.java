package com.fastpay.sdkapi.controllers;

import com.fastpay.sdkapi.dto.pay.PayUsingCredentialResponse;
import com.fastpay.sdkapi.dto.pay.PayUsingCredentialsRequest;
import com.fastpay.sdkapi.services.PayUsingCredentialsService;
import com.fastpay.sdkapi.dto.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/api/v1/public/sdk/payment/pay")
public class PayUsingCredentialsController {

    @Autowired
    private PayUsingCredentialsService payUsingCredentialsService;

    @PostMapping(consumes = "application/json")
    public ResponseEntity<ApiResponse> pay(@Valid @RequestBody PayUsingCredentialsRequest payUsingCredentialsRequest) {

    	PayUsingCredentialResponse payUsingCredentialResponse = payUsingCredentialsService.callPaymentService(payUsingCredentialsRequest);

    	switch (payUsingCredentialResponse.getCode()) {

            case 200:
                return new ResponseEntity<>(new ApiResponse("Payment was successful.", payUsingCredentialResponse.getData()), HttpStatus.OK);
            case 500:
                return new ResponseEntity<>(new ApiResponse(HttpStatus.INTERNAL_SERVER_ERROR,"Something went wrong.", payUsingCredentialResponse.getMessages()), HttpStatus.INTERNAL_SERVER_ERROR);
            default:
                return new ResponseEntity<>(new ApiResponse("Unsuccessful attempt", payUsingCredentialResponse.getMessages()), HttpStatus.BAD_REQUEST);
        }

    }
}
