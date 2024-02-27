package com.gdv.hotelservice.repositories;

import com.gdv.hotelservice.entities.Hotel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends MongoRepository<Hotel, String> {
}
