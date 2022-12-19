package com.fastpay.sdkapi.dto.pay;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Recipient {
	
	private String name;
	
	private String mobileNumber;
	
	private String avatar;
	
	public Recipient() {
		
	}

	public Recipient(String name, String mobileNumber, String avatar) {
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.avatar = avatar;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
	
}
