package com.fastpay.sdkapi.dto.validation;

import com.fastpay.sdkapi.validators.StoreIdMustExists;

import javax.validation.constraints.NotEmpty;

public class PaymentValidationRequest {

    @NotEmpty
    @StoreIdMustExists
    private String storeId;

    @NotEmpty
    private String storePassword;

    @NotEmpty
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
        return "PaymentValidationRequest{" +
                "storeId='" + storeId + '\'' +
                ", storePassword='" + storePassword + '\'' +
                ", orderId='" + orderId + '\'' +
                '}';
    }
}
