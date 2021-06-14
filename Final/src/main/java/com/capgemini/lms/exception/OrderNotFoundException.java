package com.capgemini.lms.exception;

public class OrderNotFoundException extends Exception{
	private static final long serialVersionUID = 1L;
	String message;
	public OrderNotFoundException(String message) {
			super();
			this.message = message;
		}

		@Override
		public String getMessage() {
			return message;

		}
	}

