package com.gdv.user.services.exceptions;

public class DataAlreadyExistsException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public DataAlreadyExistsException() {
		super("Data already exists");
	}
	
	public DataAlreadyExistsException(String message) {
		super(message);
	}
}
