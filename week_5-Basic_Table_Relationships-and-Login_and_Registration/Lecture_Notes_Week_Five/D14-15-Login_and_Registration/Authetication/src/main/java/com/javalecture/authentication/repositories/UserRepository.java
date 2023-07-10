package com.javalecture.authentication.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javalecture.authentication.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
	// Retrieves all users from db.
	List<User> findAll();
	
	// Retrieves a user by their email
	Optional<User> findByEmail(String email);
}
