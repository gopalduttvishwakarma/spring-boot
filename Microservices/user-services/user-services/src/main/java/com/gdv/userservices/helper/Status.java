package com.gdv.userservices.helper;

public enum Status {
    SUCCESS(200),
    FAILED(500),
    NOTFOUND(404);

    public int status;
    Status(int status) { this.status = status; }
    public int value() { return this.status; }
}
