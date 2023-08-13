package com.example.spring5webapp.ExceptionHandler;

public class IdNotFoundException extends RuntimeException {


	public IdNotFoundException(String message){
		super(message);
	}
	
}
