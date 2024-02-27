package com.gdv.hotelservice.exceptions;

public class HotelServiceException extends RuntimeException{

    private String message;
    public HotelServiceException(String message) {
        super(message);
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
