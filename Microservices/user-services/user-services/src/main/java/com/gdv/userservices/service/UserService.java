package com.gdv.userservices.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gdv.userservices.entities.Hotel;
import com.gdv.userservices.entities.Rating;
import com.gdv.userservices.entities.User;
import com.gdv.userservices.exceptions.UserServiceExceptions;
import com.gdv.userservices.helper.ApiResponse;
import com.gdv.userservices.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RestTemplate restTemplate;

    public String getHotel() {
        ResponseEntity<String> res = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels", String.class);
        return res.getBody();
    }

    public User addUser(User user) {
        user.setUserId(UUID.randomUUID().toString());
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> userWithRatingsService(String userId) {
        Optional<User> user = userRepository.findById(userId);
        List<Rating> rating = null;
        if (user.isPresent()) {
            try {
                Rating[] ratingResponse = restTemplate.getForObject("http://RATING-SERVICE/user-ratings/"+userId, Rating[].class);
                rating = List.of(ratingResponse);
                if (!rating.isEmpty()) {
                    List<Rating> ratingList = rating.stream().peek((item) -> {
                        ApiResponse hotelResponse = restTemplate.getForObject("http://HOTEL-SERVICE/hotels/get-hotel-by-id/" + item.getHotelId(), ApiResponse.class);
                        ObjectMapper mapper = new ObjectMapper();
                        item.setHotel(mapper.convertValue(hotelResponse.getData(), Hotel.class));
                    }).toList();
                }
            }
            catch (Exception ex) {
                throw new UserServiceExceptions(ex.getMessage());
            }
        }
        user.get().setRatings(rating);
        return user;
    }

    public Optional<User> userByIdService(String userId){
        return userRepository.findById(userId);
    }
}
