package com.capgemini.lms.exception;

public class FeedbackNotFoundException extends Exception{
	private static final long serialVersionUID = 1L;
	String message;
	public FeedbackNotFoundException(String message) {
			super();
			this.message = message;
		}

		@Override
		public String getMessage() {
			return message;

		}
	}

