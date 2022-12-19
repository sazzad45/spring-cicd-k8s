package com.fastpay.sdkapi.exceptions;

public class StoreIdAndStorePasswordCombinationDidNotMatchException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StoreIdAndStorePasswordCombinationDidNotMatchException() {
        super("Store ID and Store Password combination did not match.");
    }
}
