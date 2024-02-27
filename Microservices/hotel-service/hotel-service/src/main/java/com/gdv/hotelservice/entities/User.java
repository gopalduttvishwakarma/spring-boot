package com.gdv.hotelservice.entities;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class User {
    private String userId;
    private String userName;
    private String userMobile;
    private Rating ratings;
}
