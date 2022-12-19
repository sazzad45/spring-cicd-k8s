package com.fastpay.sdkapi.dto.pay;

public class Data {
	
	private SummaryPayload summary;
	
	public Data() {
		
	}

	public Data(SummaryPayload summary) {
		this.summary = summary;
	}

	public SummaryPayload getSummary() {
		return summary;
	}

	public void setSummary(SummaryPayload summary) {
		this.summary = summary;
	} 
}
