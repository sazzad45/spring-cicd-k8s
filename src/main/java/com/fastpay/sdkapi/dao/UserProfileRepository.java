package com.fastpay.sdkapi.dao;

import com.fastpay.sdkapi.entities.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

	public UserProfile findByUserId(Long userId);
}
