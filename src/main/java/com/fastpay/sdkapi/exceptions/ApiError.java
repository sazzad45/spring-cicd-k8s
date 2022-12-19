package com.fastpay.sdkapi.exceptions;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.List;

public class ApiError {

    private HttpStatus code;
    private String message;
    private List<String> errors;
    private Object data;

    public ApiError(HttpStatus code, String message, List<String> errors) {
        super();
        this.code = code;
        this.message = message;
        this.errors = errors;
    }

    public ApiError(HttpStatus code, String message, String error) {
        super();
        this.code = code;
        this.message = message;
        errors = Arrays.asList(error);
    }

	public int getCode() {
		return code.value();
	}

	@JsonIgnore
	public HttpStatus getCodeInString() {
		return code;
	}

	public void setCode(HttpStatus code) {
		this.code = code;
	}

	public String getMessage() {
		
		if (String.valueOf(getCode()).startsWith("4"))
			return "Invalid Request";
		
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