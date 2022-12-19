package com.fastpay.sdkapi.services;

import com.fastpay.sdkapi.dto.cart.Cart;
import com.fastpay.sdkapi.dto.cart.Item;
import com.fastpay.sdkapi.dto.initiation.PaymentInitiationRequest;
import com.fastpay.sdkapi.dto.initiation.PaymentInitiationResponse;
import com.fastpay.sdkapi.dto.qr.Qr;
import com.fastpay.sdkapi.utils.QrUtils;
import com.fastpay.sdkapi.entities.PaymentInitiation;
import com.fastpay.sdkapi.entities.QrWarehouse;
import com.fastpay.sdkapi.entities.StoreConfiguration;
import com.fastpay.sdkapi.entities.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fastpay.sdkapi.dao.PaymentInitiationRepository;
import com.fastpay.sdkapi.dao.QrWarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class PaymentInitiationService {

	@Autowired
	PaymentInitiationRepository paymentInitiationRepository;

	@Autowired
	QrWarehouseRepository qrWarehouseRepository;

	@Value("${wallet.payment.currency}")
	private String currency;

	public List<PaymentInitiation> findByUserIdAndOrderId(Long userId, String orderId) {
		return paymentInitiationRepository.findByUserIdAndOrderId(userId, orderId);
	}

	@Transactional
	public PaymentInitiationResponse generatePaymentToken(PaymentInitiationRequest paymentInitiationRequest,
														  StoreConfiguration store, User user) throws JsonProcessingException {

		Qr qr = QrUtils.buildQrPayload(paymentInitiationRequest, store, user);

		QrWarehouse qrWarehouse = qrWarehouseRepository.save(newQrWarehouseObject(user, qr));

		PaymentInitiation paymentInitiation = paymentInitiationRepository
				.save(newPaymentInitiationObject(user, paymentInitiationRequest, qrWarehouse));

		PaymentInitiationResponse paymentInitiationResponse = buildPaymentInitiationResponse(store, user,
				paymentInitiation);

		return paymentInitiationResponse;
	}

	private PaymentInitiationResponse buildPaymentInitiationResponse(StoreConfiguration store, User user,
			PaymentInitiation paymentInitiation) {

		PaymentInitiationResponse paymentInitiationResponse = new PaymentInitiationResponse();
		paymentInitiationResponse.setStoreName(user.getFullName());
		paymentInitiationResponse.setStoreLogo(store.getStoreLogo());
		paymentInitiationResponse.setBillAmount(paymentInitiation.getBillAmount());
		paymentInitiationResponse.setCurrency(currency);
		paymentInitiationResponse.setOrderId(paymentInitiation.getOrderId());
		paymentInitiationResponse.setToken(paymentInitiation.getQrWarehouseUuid());
		paymentInitiationResponse.setQrToken(paymentInitiation.getQrWarehouseUuid());

		return paymentInitiationResponse;
	}

	private PaymentInitiation newPaymentInitiationObject(User user, PaymentInitiationRequest paymentInitiationRequest,
			QrWarehouse qrWarehouse) throws JsonProcessingException {

		Cart cart = new Cart(
				Arrays.asList(new Item("Payment", 1, BigDecimal.valueOf(paymentInitiationRequest.getBillAmount()),
						BigDecimal.valueOf(paymentInitiationRequest.getBillAmount()))));

		PaymentInitiation paymentInitiation = new PaymentInitiation();
		paymentInitiation.setUserId(user.getUserId());
		paymentInitiation.setQrWarehouseUuid(qrWarehouse.getUuid());
		paymentInitiation.setOrderId(paymentInitiationRequest.getOrderId());
		paymentInitiation.setBillAmount(paymentInitiationRequest.getBillAmount());
		paymentInitiation.setPayload(new ObjectMapper().writeValueAsString(cart.getItems()));
		paymentInitiation.setStatus(0);

		return paymentInitiation;
	}

	private QrWarehouse newQrWarehouseObject(User user, Qr qr) throws JsonProcessingException {

		QrWarehouse qrWarehouse = new QrWarehouse();
		qrWarehouse.setUserId(user.getUserId());
		qrWarehouse.setType("PaymentQR");
		qrWarehouse.setUuid(UUID.randomUUID().toString());
		qrWarehouse.setPayload(new ObjectMapper().writeValueAsString(qr));
		qrWarehouse.setStatus(0);

		return qrWarehouse;
	}
}
