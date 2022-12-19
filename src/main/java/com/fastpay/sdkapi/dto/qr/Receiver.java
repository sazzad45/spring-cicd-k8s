package com.fastpay.sdkapi.dto.qr;

public class Receiver {
	
	private String name;
	
	private String msisdn;
	
	private String thumbnail;
	
	public Receiver() {
		
	}

	public Receiver(String name, String msisdn, String thumbnail) {
		super();
		this.name = name;
		this.msisdn = msisdn;
		this.thumbnail = thumbnail;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	
	
}
