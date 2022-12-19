package com.fastpay.sdkapi.dao;

import com.fastpay.sdkapi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>  {
	
	public User findByUserId(Long id);
}