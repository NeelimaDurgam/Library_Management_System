package com.capgemini.lms.exception;

public class AuthorNotFoundException extends Exception{
	private static final long serialVersionUID = 1L;
	String message;
	public AuthorNotFoundException(String message) {
			super();
			this.message = message;
		}

		@Override
		public String getMessage() {
			return message;

		}
	}

