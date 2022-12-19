package com.fastpay.sdkapi.utils;

import java.util.ArrayList;
import java.util.List;

import com.fastpay.sdkapi.dto.initiation.PaymentInitiationRequest;
import com.fastpay.sdkapi.dto.qr.Param;
import com.fastpay.sdkapi.dto.qr.Qr;
import com.fastpay.sdkapi.dto.qr.Receiver;
import com.fastpay.sdkapi.entities.StoreConfiguration;
import com.fastpay.sdkapi.entities.User;

public class QrUtils {

	public static Qr buildQrPayload(PaymentInitiationRequest paymentInitiationRequest,
									StoreConfiguration storeConfiguration, User user) {

		Receiver receiver = buildReceiverObject(user, storeConfiguration);
		List<Param> params = buildParamsList(paymentInitiationRequest);

		Qr qr = new Qr(receiver, params);

		return qr;
	}

	private static List<Param> buildParamsList(PaymentInitiationRequest paymentInitiationRequest) {

		List<Param> params = new ArrayList<Param>();

		params.add(new Param("numeric", "Amount", "amount", String.valueOf(paymentInitiationRequest.getBillAmount()),
				"IQD", true, "numeric", true, true));
		params.add(new Param("text", "Order ID", "order_id", String.valueOf(paymentInitiationRequest.getOrderId()), "",
				true, "alphanumeric", true, true));
		params.add(
				new Param("textarea", "Write a note (optional)", "note", "", "", true, "alphanumeric", false, false));

		return params;
	}

	private static Receiver buildReceiverObject(User user, StoreConfiguration store) {

		Receiver receiver = new Receiver();
		receiver.setName(user.getFullName());
		receiver.setMsisdn(user.getMobileNo());
		receiver.setThumbnail(store.getStoreLogo());

		return receiver;
	}
}
