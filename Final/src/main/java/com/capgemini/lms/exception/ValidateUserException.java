package com.capgemini.lms.exception;

public class ValidateUserException extends Exception{
	private static final long serialVersionUID = 1L;
	String message;

	public ValidateUserException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;

	}
}
