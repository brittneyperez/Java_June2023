package com.javalecture.loginregistration.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javalecture.loginregistration.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
	// Retrieves all users from db:
	List<User> findAll();
	
	// Retrieves a user by their email:
	Optional<User> findByEmail(String email);
	
	// Retrieves a user by their username:
	Optional<User> findByUsername(String username);
	
	// Retrieves a user by their username:
	Optional<User> findByDateOfBirth(LocalDate dateOfBirth);
}
