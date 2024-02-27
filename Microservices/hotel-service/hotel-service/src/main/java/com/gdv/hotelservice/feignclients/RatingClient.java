package com.gdv.hotelservice.feignclients;

import com.gdv.hotelservice.entities.Rating;
import com.gdv.hotelservice.helper.ApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("RATING-SERVICE")
public interface RatingClient {
    @GetMapping("/ratings-by-hotelId/{hotelId}")
    ApiResponse getRatingsByHotelId(@PathVariable String hotelId);
}
