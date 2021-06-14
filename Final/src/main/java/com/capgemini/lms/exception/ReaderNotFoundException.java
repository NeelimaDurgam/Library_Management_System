package com.capgemini.lms.exception;

public class ReaderNotFoundException  extends Exception{
	private static final long serialVersionUID = 1L;
	String message;
	public ReaderNotFoundException(String message) {
			super();
			this.message = message;
		}

		@Override
		public String getMessage() {
			return message;

		}
	}

