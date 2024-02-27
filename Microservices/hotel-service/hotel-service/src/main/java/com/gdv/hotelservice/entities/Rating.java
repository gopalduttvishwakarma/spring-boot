package com.gdv.hotelservice.entities;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Rating {
    private String _id;
    private String userId;
    private String hotelId;
    private int rating;
    private String feedback;
    private int __v;
    private User user;
}
