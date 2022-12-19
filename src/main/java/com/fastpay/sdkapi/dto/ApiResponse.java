package com.fastpay.sdkapi.dto;

import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

public class ApiResponse {

	private HttpStatus code;
	
	private String message;
	
	private List<String> errors;

	private Object data;

	public ApiResponse(HttpStatus code, String message, List<String> errors, Object data) {
		super();
		this.code = code;
		this.message = message;
		this.errors = errors;
		this.data = data;
	}
	
	public ApiResponse(HttpStatus code, String message, List<String> errors) {
		this(code, message, errors, null);
	}
	
	public ApiResponse(HttpStatus code, String message) {
		this(code, message, new ArrayList<>());
	}
	
	public ApiResponse(Object data) {
		this(HttpStatus.OK, "", new ArrayList<>(), data);
	}
	
	public ApiResponse(String message, Object data) {
		this(HttpStatus.OK, message, new ArrayList<>(), data);
	}
	
	public ApiResponse(String message, List<String> errors) {
		this(HttpStatus.BAD_REQUEST, message, errors);
	}

	public int getCode() {
		return code.value();
	}

	public void setCode(HttpStatus code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	
}
