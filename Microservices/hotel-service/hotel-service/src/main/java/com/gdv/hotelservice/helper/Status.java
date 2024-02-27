package com.gdv.hotelservice.helper;

public enum Status {
    SUCCESS(200),
    FAILED(500),
    NOTFOUND(404);

    public int status;
    Status(int status) { this.status = status; }
}
