package com.example.spring5webapp.ExceptionHandler;

import org.springframework.http.HttpStatus;


public class ErrorEntity {

	private HttpStatus httpStatus;
	private String message;
	public ErrorEntity(HttpStatus httpStatus, String message) {
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
	public ErrorEntity() {
		super();
	}
	
	
}
