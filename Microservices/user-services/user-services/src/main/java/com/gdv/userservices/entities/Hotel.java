package com.gdv.userservices.entities;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Hotel {
    private String hotelId;
    private String hotelName;
    private String hotelAddress;
    private String hotelType;
}
