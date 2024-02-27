package com.gdv.hotelservice.exceptions;

import com.gdv.hotelservice.helper.ApiResponse;
import com.gdv.hotelservice.helper.Status;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(value = HotelServiceException.class)
    public ResponseEntity<ApiResponse> handleException(HotelServiceException ex) {
        return new ResponseEntity<>(
                ApiResponse.builder()
                        .status(Status.FAILED)
                        .message("Exception occurred : " + ex.getMessage())
                        .build(),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
