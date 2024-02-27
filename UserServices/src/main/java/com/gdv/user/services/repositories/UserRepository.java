package com.gdv.user.services.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gdv.user.services.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	//TODO : we can define method according to our needs
}
