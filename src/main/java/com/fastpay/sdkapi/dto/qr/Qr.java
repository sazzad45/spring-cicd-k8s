package com.fastpay.sdkapi.dto.qr;

import java.util.List;

public class Qr {
	
	private Receiver receiver;
	
	private List<Param> params;

	public Qr(Receiver receiver, List<Param> params) {
		super();
		this.receiver = receiver;
		this.params = params;
	}

	public Receiver getReceiver() {
		return receiver;
	}

	public void setReceiver(Receiver receiver) {
		this.receiver = receiver;
	}

	public List<Param> getParams() {
		return params;
	}

	public void setParams(List<Param> params) {
		this.params = params;
	}

}