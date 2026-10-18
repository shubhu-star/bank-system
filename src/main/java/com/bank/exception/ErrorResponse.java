package com.bank.exception;

public class ErrorResponse {
	
	private int status;
	private String message;
	
	
	public ErrorResponse(int status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public int getStatus() {
		return status;
	}
		
	public String getMessage() {
		return message;
	}
	
}
