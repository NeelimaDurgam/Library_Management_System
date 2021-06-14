package com.capgemini.lms.constants;

public class SuccessMessage {
private String message;

	
	public SuccessMessage(String message) {
		super();
		this.message = message;
	}
	
	public SuccessMessage() {
		super();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}