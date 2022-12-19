package com.fastpay.sdkapi.dto.cart;

import java.math.BigDecimal;

public class Item {
	
	private String name;
	private int qty;
	private BigDecimal unit_price;
	private BigDecimal sub_total;
	
	public Item() {
		
	}
	
	public Item(String name, int qty, BigDecimal unit_price, BigDecimal sub_total) {
		super();
		this.name = name;
		this.qty = qty;
		this.unit_price = unit_price;
		this.sub_total = sub_total;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public BigDecimal getUnit_price() {
		return unit_price;
	}

	public void setUnit_price(BigDecimal unit_price) {
		this.unit_price = unit_price;
	}

	public BigDecimal getSub_total() {
		return sub_total;
	}

	public void setSub_total(BigDecimal sub_total) {
		this.sub_total = sub_total;
	}
	
	
}
