package com.gdv.userservices.exceptions;

public class UserServiceExceptions extends RuntimeException {
    private String message;

    public UserServiceExceptions() {}
    public UserServiceExceptions(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
