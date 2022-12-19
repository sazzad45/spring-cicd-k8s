package com.fastpay.sdkapi.services;

import com.fastpay.sdkapi.dto.validation.PaymentValidationRequest;
import com.fastpay.sdkapi.dto.validation.PaymentValidationResponse;
import com.fastpay.sdkapi.dto.validation.SnakeCasedPaymentValidationRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class PaymentValidationService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Value("${wallet.payment.validationUrl}")
    private String paymentValidationUrl;

    @Autowired
    private WebClient.Builder webClientBuilder;

    public PaymentValidationResponse callPaymentValidationService(PaymentValidationRequest paymentValidationRequest) {

        SnakeCasedPaymentValidationRequest snakeCasedPaymentValidationRequest = new SnakeCasedPaymentValidationRequest();

        BeanUtils.copyProperties(paymentValidationRequest, snakeCasedPaymentValidationRequest);

        PaymentValidationResponse paymentValidationResponse = webClientBuilder.build()
                .post()
                .uri("https://apigw-merchant.fast-pay.iq/api/v1/public/pgw/payment/validate")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(snakeCasedPaymentValidationRequest)
                .retrieve()
                .bodyToMono(PaymentValidationResponse.class)
                .block();

        log.info(paymentValidationResponse.toString());

        return paymentValidationResponse;
    }
}
