package com.gdv.user.services.dao;

import java.util.List;
import java.util.Optional;

import com.gdv.user.services.entities.User;


public interface UserService {
	public User addUser(User user);
	public Optional<User> getUser(int userId);
	public List<User> getAllUser();
//	public void deleteUser(int userId);
}