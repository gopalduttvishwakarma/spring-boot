package com.gdv.userservices.controller;

import com.gdv.userservices.entities.User;
import com.gdv.userservices.helper.ApiResponse;
import com.gdv.userservices.helper.Status;
import com.gdv.userservices.service.UserService;
import jakarta.ws.rs.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping
    public ResponseEntity<ApiResponse> getUsers() {
        List<User> allUsers = userService.getAllUsers();

        if (allUsers.size() > 0) {
            return new ResponseEntity<>(
                    ApiResponse.builder()
                            .message("User available")
                            .data(allUsers)
                            .status(Status.SUCCESS).build(),
                    HttpStatus.FOUND);
        }
        else {
            return new ResponseEntity<>(
                    ApiResponse.builder()
                            .message("User does not available")
                            .status(Status.NOTFOUND).build(),
                    HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/hotels")
    public String getHotel() { return userService.getHotel(); }

    @PostMapping("/add-user")
    public ResponseEntity<ApiResponse> addUser(@RequestBody User user) {
        User response = userService.addUser(user);

        if (response != null) {
            return new ResponseEntity<>(
                    ApiResponse.builder()
                            .message("User added successfully")
                            .data(response)
                            .status(Status.SUCCESS).build(),
                    HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>(
                    ApiResponse.builder()
                            .message("User does not added")
                            .status(Status.FAILED).build(),
                    HttpStatus.NOT_MODIFIED);
        }
    }

    @GetMapping("/user-ratings/{userId}")
    public ResponseEntity<ApiResponse> getUserWithRating(@PathVariable String userId) {
        Optional<User> user = userService.userWithRatingsService(userId);
        if (user != null) {
            return new ResponseEntity<>(
                    ApiResponse.builder()
                            .message("User available")
                            .data(user)
                            .status(Status.SUCCESS).build(),
                    HttpStatus.FOUND);
        }
        else {
            return new ResponseEntity<>(
                    ApiResponse.builder()
                            .message("User does not available")
                            .status(Status.NOTFOUND).build(),
                    HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/user-by-id/{userId}")
    public ResponseEntity<ApiResponse> userById(@PathVariable String userId) {
        Optional<User> response = userService.userByIdService(userId);

        if (response.isPresent()) {
            return new ResponseEntity<>(
                    ApiResponse.builder()
                            .message("User found successfully")
                            .data(response)
                            .status(Status.SUCCESS).build(),
                    HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>(
                    ApiResponse.builder()
                            .message("User does not found")
                            .status(Status.FAILED).build(),
                    HttpStatus.NOT_MODIFIED);
        }
    }
}
