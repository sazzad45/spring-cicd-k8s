package com.fastpay.sdkapi.dto.initiation;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fastpay.sdkapi.validators.StoreIdMustExists;
import com.fastpay.sdkapi.enums.Currency;

public class PaymentInitiationRequest {

	@NotEmpty
	@StoreIdMustExists
	private String storeId;

	@NotEmpty
	private String storePassword;

	@NotEmpty
	private String orderId;

	@Min(value = 250)
	private int billAmount;

	@Enumerated(EnumType.STRING)
	@NotNull
	private Currency currency;

	public PaymentInitiationRequest(String storeId, String storePassword, String orderId, int billAmount,
			Currency currency) {
		super();
		this.storeId = storeId;
		this.storePassword = storePassword;
		this.orderId = orderId;
		this.billAmount = billAmount;
		this.currency = currency;
	}

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

	public int getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(int billAmount) {
		this.billAmount = billAmount;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

}
