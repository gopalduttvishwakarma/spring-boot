package com.gdv.hotelservice.entities;

import lombok.*;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(value = "hotel")
public class Hotel {
    @MongoId
    private String hotelId;
    private String hotelName;
    private String hotelAddress;
    private String hotelType;

    @Transient
    private List<Rating> ratings;
}
