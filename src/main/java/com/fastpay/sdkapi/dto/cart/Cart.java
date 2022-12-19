package com.fastpay.sdkapi.dto.cart;

import java.util.List;

public class Cart {
	
	private List<Item> items;

	public Cart(List<Item> items) {
		super();
		this.items = items;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
}
