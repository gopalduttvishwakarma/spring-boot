package com.gdv.hotelservice.helper;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {
    private Status status;
    private String message;
    private T data;
}
