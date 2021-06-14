package com.capgemini.lms.exception;

public class SubscriptionExpiredException extends Exception{
	private static final long serialVersionUID = 1L;
	String message;
	public SubscriptionExpiredException(String message) {
			super();
			this.message = message;
		}

		@Override
		public String getMessage() {
			return message;

		}
	}


