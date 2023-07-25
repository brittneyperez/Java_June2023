package com.javastack.projectmanager.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javastack.projectmanager.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	// Retrieve all users from db:
	List<User> findAll();
	// Retrieve user by email:
	Optional<User> findByEmail( String email );
	// Retrieve user by username:
	Optional<User> findByUsername( String username );
}
