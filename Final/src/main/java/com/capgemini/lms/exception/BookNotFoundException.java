package com.capgemini.lms.exception;

public class BookNotFoundException extends Exception{
	private static final long serialVersionUID = 1L;
	String message;
	public BookNotFoundException(String message) {
			super();
			this.message = message;
		}

		@Override
		public String getMessage() {
			return message;

		}
	}


