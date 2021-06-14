package com.capgemini.lms.exception;

public class UserNotFoundException extends Exception{
	private static final long serialVersionUID = 1L;
	String message;
	public UserNotFoundException(String message) {
			super();
			this.message = message;
		}

		@Override
		public String getMessage() {
			return message;

		}
	}

