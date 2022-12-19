package com.fastpay.sdkapi.services;

import com.fastpay.sdkapi.dto.pay.PayUsingCredentialResponse;
import com.fastpay.sdkapi.dto.pay.PayUsingCredentialsRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class PayUsingCredentialsService {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Value("${wallet.payment.confirmation}")
	private String paymentConfirmationUrl;
    
    public PayUsingCredentialResponse callPaymentService(PayUsingCredentialsRequest payUsingCredentialsRequest) {
    	
    	PayUsingCredentialResponse payUsingCredentialResponse = webClientBuilder.build()
    		.post()
    		.uri("https://apigw-merchant.fast-pay.iq/api/v1/public/pgw/payment/execute")
    		.contentType(MediaType.APPLICATION_JSON)
    		.bodyValue(payUsingCredentialsRequest)
    		.retrieve()
    		.bodyToMono(PayUsingCredentialResponse.class)
    		.block();
    	
    	log.info(payUsingCredentialResponse.toString());
    	
    	return payUsingCredentialResponse;
    }
}
