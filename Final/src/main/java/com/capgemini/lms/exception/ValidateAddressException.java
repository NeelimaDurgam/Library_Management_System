package com.capgemini.lms.exception;

public class ValidateAddressException extends Exception {
	private static final long serialVersionUID = 1L;
	String message;

	public ValidateAddressException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;

	}
}
