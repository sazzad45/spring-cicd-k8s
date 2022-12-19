package com.fastpay.sdkapi.dao;

import com.fastpay.sdkapi.entities.QrWarehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QrWarehouseRepository extends JpaRepository<QrWarehouse, Long> {
	
	
}
