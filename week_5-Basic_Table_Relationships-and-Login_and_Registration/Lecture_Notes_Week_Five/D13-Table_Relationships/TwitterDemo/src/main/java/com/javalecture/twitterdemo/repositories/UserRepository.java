package com.javalecture.twitterdemo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javalecture.twitterdemo.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
	// This method retrieves all users from db.
	List<User> findAll();
}
