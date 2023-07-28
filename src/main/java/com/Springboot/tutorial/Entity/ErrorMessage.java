package com.Springboot.tutorial.Entity;

import org.springframework.http.HttpStatus;

public class ErrorMessage {
	
	private HttpStatus httpStatus;
	private String message;
	
	
	@Override
	public String toString() {
		return "ErrorMessage [httpStatus=" + httpStatus + ", message=" + message + "]";
	}
	public ErrorMessage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ErrorMessage(HttpStatus httpStatus, String message) {
		super();
		this.httpStatus = httpStatus;
		this.message = message;
	}
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
