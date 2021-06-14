package com.capgemini.lms.exception;

public class ValidateReaderException extends Exception{
		private static final long serialVersionUID = 1L;
		String message;

		public ValidateReaderException(String message) {
			super();
			this.message = message;
		}

		@Override
		public String getMessage() {
			return message;

		}

}
