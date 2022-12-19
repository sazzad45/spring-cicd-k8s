package com.fastpay.sdkapi.dto.qr;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Param {
	
	private String fieldType;
	
	private String label;
	
	private String key;
	
	private String value;
	
	private String placeholder;
	
	private boolean input;
	
	private String type;
	
	private boolean required;
		
	private boolean isReadOnly;

	public Param(String fieldType, String label, String key, String value, String placeholder, boolean input,
			String type, boolean required, boolean isReadOnly) {
		super();
		this.fieldType = fieldType;
		this.label = label;
		this.key = key;
		this.value = value;
		this.placeholder = placeholder;
		this.input = input;
		this.type = type;
		this.required = required;
		this.isReadOnly = isReadOnly;
	}

	public String getFieldType() {
		return fieldType;
	}

	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getPlaceholder() {
		return placeholder;
	}

	public void setPlaceholder(String placeholder) {
		this.placeholder = placeholder;
	}

	public boolean isInput() {
		return input;
	}

	public void setInput(boolean input) {
		this.input = input;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isRequired() {
		return required;
	}

	public void setRequired(boolean required) {
		this.required = required;
	}

	@JsonProperty("is_read_only")
	public boolean isReadOnly() {
		return isReadOnly;
	}

	public void setReadOnly(boolean isReadOnly) {
		this.isReadOnly = isReadOnly;
	}
	
	
}