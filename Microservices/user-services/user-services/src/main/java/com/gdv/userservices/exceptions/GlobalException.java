package com.gdv.userservices.exceptions;

import com.gdv.userservices.helper.ApiResponse;
import com.gdv.userservices.helper.Status;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler(value = UserServiceExceptions.class)
    public ResponseEntity<ApiResponse> handleException(UserServiceExceptions ex) {
        return new ResponseEntity<>(
                ApiResponse.builder()
                        .status(Status.FAILED)
                        .message("Exception occurred : " + ex.getMessage())
                        .build(),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}
