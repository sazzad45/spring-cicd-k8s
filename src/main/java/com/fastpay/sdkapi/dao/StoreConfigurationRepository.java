package com.fastpay.sdkapi.dao;

import com.fastpay.sdkapi.entities.StoreConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreConfigurationRepository extends JpaRepository<StoreConfiguration, Long> {

	StoreConfiguration findByStoreId(String value);
}
