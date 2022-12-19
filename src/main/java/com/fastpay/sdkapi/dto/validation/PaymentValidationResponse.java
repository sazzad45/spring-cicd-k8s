package com.fastpay.sdkapi.dto.validation;

import java.util.List;

public class PaymentValidationResponse {

    private int code;

    private List<String> messages;

    private Data data;

    public PaymentValidationResponse() {
    }

    public PaymentValidationResponse(int code, List<String> messages, Data data) {
        this.code = code;
        this.messages = messages;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "PaymentValidationResponse{" +
                "code=" + code +
                ", messages=" + messages +
                ", data=" + data +
                '}';
    }
}
