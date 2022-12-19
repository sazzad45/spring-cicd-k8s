package com.fastpay.sdkapi.entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "qr_warehouses")
public class QrWarehouse {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public Long qrId;
	
	public Long userId;
	
	public String payload;
	
	public String type;
	
	public int status;
	
	public Long transactionId;
	
	public String uuid;
	
	public String txUniqueId;
	
	@CreationTimestamp
	private Timestamp createdAt;
	
	@UpdateTimestamp
	private Timestamp updatedAt;
	
	public QrWarehouse() {
		
	}

	public QrWarehouse(Long qrId, Long userId, String payload, String type, int status, Long transactionId, String uuid,
			String txUniqueId, Timestamp createdAt, Timestamp updatedAt) {
		super();
		this.qrId = qrId;
		this.userId = userId;
		this.payload = payload;
		this.type = type;
		this.status = status;
		this.transactionId = transactionId;
		this.uuid = uuid;
		this.txUniqueId = txUniqueId;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Long getQrId() {
		return qrId;
	}

	public void setQrId(Long qrId) {
		this.qrId = qrId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getPayload() {
		return payload;
	}

	public void setPayload(String payload) {
		this.payload = payload;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getTxUniqueId() {
		return txUniqueId;
	}

	public void setTxUniqueId(String txUniqueId) {
		this.txUniqueId = txUniqueId;
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
