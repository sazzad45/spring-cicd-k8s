package com.fastpay.sdkapi.dto.pay;

import java.util.List;

public class PayUsingCredentialResponse {
	
	private int code;
	
	private List<String> messages;
	
	private Data data;
	
	public PayUsingCredentialResponse() {
		
	}

	public PayUsingCredentialResponse(int code, List<String> messages, Data data) {
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
		return "PayUsingCredentialResponse [code=" + code + ", messages=" + messages + ", data=" + data + "]";
	}
	
}
