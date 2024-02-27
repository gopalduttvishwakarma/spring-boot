package com.gdv.user.services.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gdv.user.services.dao.UserService;
import com.gdv.user.services.entities.User;
import com.gdv.user.services.utils.ApiResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	UserService userService;

	@GetMapping
	public ResponseEntity<ApiResponse> getAllUser() {		
		List<User> alluser = userService.getAllUser();
		ResponseEntity<ApiResponse> response;
		if (alluser.isEmpty()) {
			response = new ResponseEntity<>(
					ApiResponse.builder().message("Data not found").build(),
					HttpStatus.NOT_FOUND
					);
		}
		else {
			response = new ResponseEntity<>(
					ApiResponse.builder().message("Data found").data(alluser).build(),
					HttpStatus.FOUND
					);
		}
		return response;
	}
	
	@PostMapping
	public ResponseEntity<ApiResponse> addUser(@RequestBody User user) {
		User u = userService.addUser(user);
		ResponseEntity<ApiResponse> response;
		if (u != null) {
			List<Object> l = new ArrayList<>();
			l.add(u);
			response = new ResponseEntity<>(
					ApiResponse.builder().message("Inserted").data(l).build(),
					HttpStatus.CREATED
					);			
		}
		else {
			response = new ResponseEntity<>(
					ApiResponse.builder().message("Not inserted").build(),
					HttpStatus.NOT_MODIFIED
					);
		}
		return response;
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<ApiResponse> getUser(@PathVariable int userId) {		
		Optional<User> alluser = userService.getUser(userId);
		ResponseEntity<ApiResponse> response;
		if (alluser != null) {
			List<Object> l = new ArrayList<>();
			l.add(alluser);
			response = new ResponseEntity<>(
					ApiResponse.builder().message("Data found").data(l).build(),
					HttpStatus.FOUND
					);
			
		}
		else {
			response = new ResponseEntity<>(
					ApiResponse.builder().message("Data not found").build(),
					HttpStatus.NOT_FOUND
					);			
		}
		return response;
	}

}