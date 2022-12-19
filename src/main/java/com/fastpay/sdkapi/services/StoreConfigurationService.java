package com.fastpay.sdkapi.services;

import com.fastpay.sdkapi.entities.StoreConfiguration;
import com.fastpay.sdkapi.dao.StoreConfigurationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreConfigurationService {

    @Autowired
    StoreConfigurationRepository storeConfigurationRepository;

    public List<StoreConfiguration> fetchListOfStore() {
        return storeConfigurationRepository.findAll();
    }

	public StoreConfiguration findByStoreId(String storeId) {
		return storeConfigurationRepository.findByStoreId(storeId);
	}
    
}
