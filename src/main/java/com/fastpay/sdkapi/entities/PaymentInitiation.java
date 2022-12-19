package com.fastpay.sdkapi.entities;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity
@Table(name = "payment_initiations")
public class PaymentInitiation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	private Long userId;

	@NotEmpty
	private String qrWarehouseUuid;

	@NotEmpty
	private String orderId;

	@NotEmpty
	private double billAmount;

	@NotEmpty
	private String payload;

	@NotEmpty
	private int status;

	@NotNull
	@CreationTimestamp
	private Timestamp createdAt;

	@NotNull
	@UpdateTimestamp
	private Timestamp updatedAt;
	
	public PaymentInitiation() {
		
	}

	public PaymentInitiation(Long id, Long userId, String qrWarehouseUuid, String orderId, double billAmount,
			String payload, int status, Timestamp createdAt, Timestamp updatedAt) {
		super();
		this.id = id;
		this.userId = userId;
		this.qrWarehouseUuid = qrWarehouseUuid;
		this.orderId = orderId;
		this.billAmount = billAmount;
		this.payload = payload;
		this.status = status;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getQrWarehouseUuid() {
		return qrWarehouseUuid;
	}

	public void setQrWarehouseUuid(String qrWarehouseUuid) {
		this.qrWarehouseUuid = qrWarehouseUuid;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Double getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(double billAmount) {
		this.billAmount = billAmount;
	}

	public String getPayload() {
		return payload;
	}

	public void setPayload(String payload) {
		this.payload = payload;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

}