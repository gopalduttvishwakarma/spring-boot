package com.gdv.hotelservice.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gdv.hotelservice.entities.Hotel;
import com.gdv.hotelservice.entities.Rating;
import com.gdv.hotelservice.entities.User;
import com.gdv.hotelservice.exceptions.HotelServiceException;
import com.gdv.hotelservice.feignclients.RatingClient;
import com.gdv.hotelservice.feignclients.UserClient;
import com.gdv.hotelservice.helper.ApiResponse;
import com.gdv.hotelservice.helper.Status;
import com.gdv.hotelservice.repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class HotelService {
    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private ObjectMapper mapper;
    @Autowired
    private RatingClient ratingClient;
    @Autowired
    private UserClient userClient;
    public List<Hotel> getAllHotel() {
        List<Hotel> hotelList = hotelRepository.findAll();
        List<Hotel> hotelResponse = null;
        if (!hotelList.isEmpty()) {
            try {
                hotelResponse = hotelList.stream().peek(hotel -> {
                   ApiResponse ratingResponse = ratingClient.getRatingsByHotelId(hotel.getHotelId());
                   List<Rating> ratingList = mapper.convertValue(ratingResponse.getData(), new TypeReference<List<Rating>>() {});
                   List<Rating> ratingsWithUser = ratingList.stream().peek(rating -> {
                       ApiResponse userResponse = userClient.getUserByUserId(rating.getUserId());
                       System.out.println("userResponse :: " + userResponse);
                       rating.setUser(mapper.convertValue(userResponse.getData(), User.class));
                   }).toList();
                   hotel.setRatings(ratingsWithUser);
                }).toList();
            }
            catch (Exception ex) {
                throw new HotelServiceException(ex.getMessage());
            }
        }
        return hotelResponse;
    }
    public Hotel addHotelService(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    public Optional<Hotel> getHotelById(String hotelId) {
        return hotelRepository.findById(hotelId);
    }
}
