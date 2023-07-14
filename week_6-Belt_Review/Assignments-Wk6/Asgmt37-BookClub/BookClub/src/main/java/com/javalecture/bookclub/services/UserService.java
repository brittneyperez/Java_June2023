package com.javalecture.bookclub.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javalecture.bookclub.models.User;
import com.javalecture.bookclub.repositories.UserRepository;

@Service
public class UserService {
	
	// Connection to Repository from Service
	@Autowired
	private UserRepository uRepo;
	
	// * CREATE
	public User createUser( User newUser ) {
		return uRepo.save(newUser);
	}
	
	// * READ ALL
	
	// * READ ONE
	public User findByUserById( Long id ) {
		User existingUser = uRepo.findById(id).orElse(null);
		return existingUser;
	}
	
	// * UPDATE
	
	// * DELETE
	
}
