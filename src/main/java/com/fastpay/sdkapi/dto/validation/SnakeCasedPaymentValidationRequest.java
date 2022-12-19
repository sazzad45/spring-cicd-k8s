package com.fastpay.sdkapi.dto.validation;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class SnakeCasedPaymentValidationRequest {

    private String storeId;

    private String storePassword;

    private String orderId;

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getStorePassword() {
        return storePassword;
    }

    public void setStorePassword(String storePassword) {
        this.storePassword = storePassword;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "SnakeCasedPaymentValidationRequest{" +
                "storeId='" + storeId + '\'' +
                ", storePassword='" + storePassword + '\'' +
                ", orderId='" + orderId + '\'' +
                '}';
    }
}
