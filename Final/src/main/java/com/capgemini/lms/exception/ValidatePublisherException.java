package com.capgemini.lms.exception;

public class ValidatePublisherException extends Exception{
	private static final long serialVersionUID = 1L;
	String message;

	public ValidatePublisherException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;

	}
}
