package com.gdv.user.services.exceptions;

public class DataNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public DataNotFoundException() {
		super("Data not found");
	}
	
	public DataNotFoundException(String message) {
		super(message);
	}
}
