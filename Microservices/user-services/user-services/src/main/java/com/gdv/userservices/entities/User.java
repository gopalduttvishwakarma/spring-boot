package com.gdv.userservices.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Table(name = "user")
public class User {
    @Id
    private String userId;
    private String userName;
    private String userMobile;

    @Transient
    private List<Rating> ratings;
}
