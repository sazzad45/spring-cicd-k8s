package com.fastpay.sdkapi.entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	@Column(name = "id")
	private Long userId;
	
	private Long userTypeId;
	
	private Long roleId;
	
	private Long userStatusId;
	
	private String mobileNo;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private int emailVerified;
	
	private String password;
	
	private String pin;
	
	private String fcmKey;
	
	private String loginCookieIdMb;
	
	private int isKycVerified;
	
	private int isFirstLogin;
	
	private Timestamp emailVerifiedAt;
	
	private int status;
	
	private String rememberToken;
	
	private Long oldId;
	
	private Timestamp createdAt;
	
	private Timestamp updatedAt;
	
	private Timestamp deletedAt;
	
	public User() {
		
	}

	public User(Long userId, Long userTypeId, Long roleId, Long userStatusId, String mobileNo, String firstName,
			String lastName, String email, int emailVerified, String password, String pin, String fcmKey,
			String loginCookieIdMb, int isKycVerified, int isFirstLogin, Timestamp emailVerifiedAt, int status,
			String rememberToken, Long oldId, Timestamp createdAt, Timestamp updatedAt, Timestamp deletedAt) {
		super();
		this.userId = userId;
		this.userTypeId = userTypeId;
		this.roleId = roleId;
		this.userStatusId = userStatusId;
		this.mobileNo = mobileNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.emailVerified = emailVerified;
		this.password = password;
		this.pin = pin;
		this.fcmKey = fcmKey;
		this.loginCookieIdMb = loginCookieIdMb;
		this.isKycVerified = isKycVerified;
		this.isFirstLogin = isFirstLogin;
		this.emailVerifiedAt = emailVerifiedAt;
		this.status = status;
		this.rememberToken = rememberToken;
		this.oldId = oldId;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getUserTypeId() {
		return userTypeId;
	}

	public void setUserTypeId(Long userTypeId) {
		this.userTypeId = userTypeId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getUserStatusId() {
		return userStatusId;
	}

	public void setUserStatusId(Long userStatusId) {
		this.userStatusId = userStatusId;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getEmailVerified() {
		return emailVerified;
	}

	public void setEmailVerified(int emailVerified) {
		this.emailVerified = emailVerified;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getFcmKey() {
		return fcmKey;
	}

	public void setFcmKey(String fcmKey) {
		this.fcmKey = fcmKey;
	}

	public String getLoginCookieIdMb() {
		return loginCookieIdMb;
	}

	public void setLoginCookieIdMb(String loginCookieIdMb) {
		this.loginCookieIdMb = loginCookieIdMb;
	}

	public int getIsKycVerified() {
		return isKycVerified;
	}

	public void setIsKycVerified(int isKycVerified) {
		this.isKycVerified = isKycVerified;
	}

	public int getIsFirstLogin() {
		return isFirstLogin;
	}

	public void setIsFirstLogin(int isFirstLogin) {
		this.isFirstLogin = isFirstLogin;
	}

	public Timestamp getEmailVerifiedAt() {
		return emailVerifiedAt;
	}

	public void setEmailVerifiedAt(Timestamp emailVerifiedAt) {
		this.emailVerifiedAt = emailVerifiedAt;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getRememberToken() {
		return rememberToken;
	}

	public void setRememberToken(String rememberToken) {
		this.rememberToken = rememberToken;
	}

	public Long getOldId() {
		return oldId;
	}

	public void setOldId(Long oldId) {
		this.oldId = oldId;
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

	public Timestamp getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(Timestamp deletedAt) {
		this.deletedAt = deletedAt;
	}

	public String getFullName() {
		return firstName + " " + lastName;
	}
	
}