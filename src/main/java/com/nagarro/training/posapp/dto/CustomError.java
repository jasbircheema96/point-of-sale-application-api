package com.nagarro.training.posapp.dto;

public class CustomError {

	private String message;

	public CustomError() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomError(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
