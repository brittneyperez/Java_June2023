package com.javalecture.bookclub.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javalecture.bookclub.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	// Retrieve all users from db:
	List<User> findAll();
	// Retrieve user by email:
	Optional<User> findByEmail( String email );
}
