package com.capgemini.lms.exception;

public class ValidateSuggestedBooksException extends Exception{
	private static final long serialVersionUID = 1L;
	String message;

	public ValidateSuggestedBooksException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;

	}
}
