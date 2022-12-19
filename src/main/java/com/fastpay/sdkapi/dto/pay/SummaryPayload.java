package com.fastpay.sdkapi.dto.pay;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class SummaryPayload {
	
	private Recipient recipient;
	
	private String invoiceId;
	
	public SummaryPayload() {
		
	}

	public SummaryPayload(Recipient recipient, String invoiceId) {
		this.recipient = recipient;
		this.invoiceId = invoiceId;
	}

	public Recipient getRecipient() {
		return recipient;
	}

	public void setRecipient(Recipient recipient) {
		this.recipient = recipient;
	}

	public String getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
	}
	
}
