package com.fastpay.sdkapi.dto.initiation;

import com.fastpay.sdkapi.utils.EncryptionHandler;

public class PaymentInitiationResponse {

	private String storeName;
	private String storeLogo;
	private String orderId;
	private double billAmount;
	private String currency;
	private String token;
	private String qrToken;

	public PaymentInitiationResponse() {
	}

	public PaymentInitiationResponse(String storeName, String storeLogo, String orderId, double billAmount,
			String currency, String token, String qrToken) {
		this.storeName = storeName;
		this.storeLogo = storeLogo;
		this.orderId = orderId;
		this.billAmount = billAmount;
		this.currency = currency;
		this.token = token;
		this.qrToken = qrToken;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getStoreLogo() {
		return storeLogo;
	}

	public void setStoreLogo(String storeLogo) {
		this.storeLogo = storeLogo;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public double getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(double billAmount) {
		this.billAmount = billAmount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getQrToken() {
		return qrToken;
	}

	public void setQrToken(String qrToken) {
		this.qrToken = this.aes256Encrypt(qrToken);
	}

	public String aes256Encrypt(String qrToken) {
		return EncryptionHandler.encryptDataWithPrefix(EncryptionHandler.encryptData(qrToken));
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
