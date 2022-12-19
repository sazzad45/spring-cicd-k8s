package com.fastpay.sdkapi.dto.validation;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Data {

    private String gwTransactionId;

    private String merchantOrderId;

    private double receivedAmount;

    private String currency;

    private String status;

    private String customerName;

    private String customerMobileNumber;

    private String at;

    public Data() {
    }

    public Data(String gwTransactionId, String merchantOrderId, double receivedAmount, String currency, String status, String customerName, String customerMobileNumber, String at) {
        this.gwTransactionId = gwTransactionId;
        this.merchantOrderId = merchantOrderId;
        this.receivedAmount = receivedAmount;
        this.currency = currency;
        this.status = status;
        this.customerName = customerName;
        this.customerMobileNumber = customerMobileNumber;
        this.at = at;
    }

    public String getGwTransactionId() {
        return gwTransactionId;
    }

    public void setGwTransactionId(String gwTransactionId) {
        this.gwTransactionId = gwTransactionId;
    }

    public String getMerchantOrderId() {
        return merchantOrderId;
    }

    public void setMerchantOrderId(String merchantOrderId) {
        this.merchantOrderId = merchantOrderId;
    }

    public double getReceivedAmount() {
        return receivedAmount;
    }

    public void setReceivedAmount(double receivedAmount) {
        this.receivedAmount = receivedAmount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerMobileNumber() {
        return customerMobileNumber;
    }

    public void setCustomerMobileNumber(String customerMobileNumber) {
        this.customerMobileNumber = customerMobileNumber;
    }

    public String getAt() {
        return at;
    }

    public void setAt(String at) {
        this.at = at;
    }
}