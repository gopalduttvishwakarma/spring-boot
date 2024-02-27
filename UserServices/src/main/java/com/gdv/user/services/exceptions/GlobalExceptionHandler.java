package com.gdv.user.services.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.gdv.user.services.utils.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(DataNotFoundException.class)
	public ResponseEntity<ApiResponse> handleDataNotFoundException(DataNotFoundException dataNotFoundException) {
		return new ResponseEntity<>(
				ApiResponse.builder().message(dataNotFoundException.getMessage()).build()
				, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(DataAlreadyExistsException.class)
	public ResponseEntity<ApiResponse> handleDataAlreadyExistsException(DataAlreadyExistsException alreadyExistsException) {
		return new ResponseEntity<>(
				ApiResponse.builder().message(alreadyExistsException.getMessage()).build()
				, HttpStatus.ALREADY_REPORTED);
	}
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ApiResponse> runtimeExceptionHandle(RuntimeException exception) {
		return new ResponseEntity<ApiResponse>(
				ApiResponse.builder().message(exception.getMessage()).build()
				, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
