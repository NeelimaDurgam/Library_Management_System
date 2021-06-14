package com.capgemini.lms.exception;

public class PublisherNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;
	String message;
	public PublisherNotFoundException(String message) {
			super();
			this.message = message;
		}

		@Override
		public String getMessage() {
			return message;

		}
	}

