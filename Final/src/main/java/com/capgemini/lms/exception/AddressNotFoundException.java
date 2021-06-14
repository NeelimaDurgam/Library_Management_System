package com.capgemini.lms.exception;

public class AddressNotFoundException extends Exception{
	private static final long serialVersionUID = 1L;
	String message;
	public AddressNotFoundException(String message) {
			super();
			this.message = message;
		}

		@Override
		public String getMessage() {
			return message;

		}
	}


