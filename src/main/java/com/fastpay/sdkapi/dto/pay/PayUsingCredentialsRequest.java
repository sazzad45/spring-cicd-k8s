package com.fastpay.sdkapi.dto.pay;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class PayUsingCredentialsRequest {

    @NotEmpty
    private String orderId;

    @NotEmpty
    private String token;

    @NotEmpty
    private String mobileNumber;

    @NotEmpty
    private String password;

    public PayUsingCredentialsRequest(String orderId, String token, String mobileNumber, String password) {
        this.orderId = orderId;
        this.token = token;
        this.mobileNumber = mobileNumber;
        this.password = password;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
