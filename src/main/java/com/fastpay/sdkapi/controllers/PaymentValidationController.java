package com.fastpay.sdkapi.controllers;

import com.fastpay.sdkapi.dto.validation.PaymentValidationRequest;
import com.fastpay.sdkapi.dto.validation.PaymentValidationResponse;
import com.fastpay.sdkapi.services.PaymentValidationService;
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
@RequestMapping(path = "/api/v1/public/sdk/payment/validate")
public class PaymentValidationController {

    @Autowired
    private PaymentValidationService paymentValidationService;

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<ApiResponse> validate(@Valid @RequestBody PaymentValidationRequest paymentValidationRequest) {
        PaymentValidationResponse paymentValidationResponse = paymentValidationService.callPaymentValidationService(paymentValidationRequest);

        switch (paymentValidationResponse.getCode()) {

            case 200:
                return new ResponseEntity<>(new ApiResponse("Payment was successful.", paymentValidationResponse.getData()), HttpStatus.OK);
            case 500:
                return new ResponseEntity<>(new ApiResponse(HttpStatus.INTERNAL_SERVER_ERROR,"Something went wrong.", paymentValidationResponse.getMessages()), HttpStatus.INTERNAL_SERVER_ERROR);
            default:
                return new ResponseEntity<>(new ApiResponse("Unsuccessful attempt", paymentValidationResponse.getMessages()), HttpStatus.BAD_REQUEST);
        }
    }

}
