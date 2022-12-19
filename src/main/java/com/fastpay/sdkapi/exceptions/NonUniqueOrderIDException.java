package com.fastpay.sdkapi.exceptions;

public class NonUniqueOrderIDException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NonUniqueOrderIDException() {
        super("Sorry! Provided Order ID matched with a previous Order ID. Kindly use a unique Order ID each time you request.");
    }
}
