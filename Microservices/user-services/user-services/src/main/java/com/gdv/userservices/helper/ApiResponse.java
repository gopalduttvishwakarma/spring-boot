package com.gdv.userservices.helper;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class ApiResponse<T> {
    private Status status;
    private String message;
    private T data;
}
