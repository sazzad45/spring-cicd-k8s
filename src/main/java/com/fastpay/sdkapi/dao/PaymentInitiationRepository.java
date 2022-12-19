package com.fastpay.sdkapi.dao;

import java.util.List;

import com.fastpay.sdkapi.entities.PaymentInitiation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentInitiationRepository extends JpaRepository<PaymentInitiation, Long> {
	
	public List<PaymentInitiation> findByUserIdAndOrderId(Long userId, String orderId);
}
