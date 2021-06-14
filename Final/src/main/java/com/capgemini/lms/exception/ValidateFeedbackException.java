package com.capgemini.lms.exception;

public class ValidateFeedbackException extends Exception {
	private static final long serialVersionUID = 1L;
	String message;

	public ValidateFeedbackException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;

	}
}
