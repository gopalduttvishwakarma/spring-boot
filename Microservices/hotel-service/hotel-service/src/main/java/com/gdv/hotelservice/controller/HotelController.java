package com.gdv.hotelservice.controller;

import com.gdv.hotelservice.entities.Hotel;
import com.gdv.hotelservice.helper.ApiResponse;
import com.gdv.hotelservice.helper.Status;
import com.gdv.hotelservice.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;
    @GetMapping
    public ResponseEntity<ApiResponse> getAllHotel() {
        List<Hotel> allHotels = hotelService.getAllHotel();
        if (allHotels.size() > 0) {
            return new ResponseEntity<>(
                    ApiResponse.builder()
                            .message("Data available")
                            .data(allHotels)
                            .status(Status.SUCCESS)
                            .build(),
                    HttpStatus.FOUND
            );
        }
        else {
            return new ResponseEntity<>(
                    ApiResponse.builder()
                            .message("Data do not available")
                            .status(Status.NOTFOUND)
                            .build(),
                    HttpStatus.NOT_FOUND
            );
        }
    }

    @PostMapping("/add-hotel")
    public ResponseEntity<ApiResponse> addHotel(@RequestBody Hotel hotel) {
        Hotel response = hotelService.addHotelService(hotel);
        if (response != null)
            return new ResponseEntity<ApiResponse>(
                    ApiResponse.builder()
                            .message("Hotel data found")
                            .status(Status.SUCCESS)
                            .data(response).build(),
                    HttpStatus.CREATED
            );
        else
            return new ResponseEntity<>(
                    ApiResponse.builder()
                        .message("Hotel data not available")
                        .status(Status.NOTFOUND).build(),
                    HttpStatus.NOT_FOUND);
    }

    @GetMapping("/get-hotel-by-id/{hotelId}")
    public ResponseEntity<ApiResponse> getHotelById(@PathVariable String hotelId) {
        Optional<Hotel> hotel = hotelService.getHotelById(hotelId);
        if (hotel.isPresent()) {
            return new ResponseEntity<>(
                    ApiResponse.builder()
                            .status(Status.SUCCESS)
                            .message("Hotel available")
                            .data(hotel)
                            .build(),
                    HttpStatus.FOUND);
        }
        else {
            return new ResponseEntity<>(
                    ApiResponse.builder()
                            .status(Status.NOTFOUND)
                            .message("Hotel no found")
                            .build(),
                    HttpStatus.NOT_FOUND
            );
        }
    }
}
