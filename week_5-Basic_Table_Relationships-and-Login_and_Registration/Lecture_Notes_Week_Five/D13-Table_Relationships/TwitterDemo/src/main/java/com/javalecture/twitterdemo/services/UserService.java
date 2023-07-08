package com.javalecture.twitterdemo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javalecture.twitterdemo.models.User;
import com.javalecture.twitterdemo.repositories.UserRepository;

@Service
public class UserService {
	// Connection to Repository from Service -- import UserRepository as a dependency
	@Autowired
	private UserRepository userRepo;
	
	// * CREATE - Take in user object and save to db.
	public User create( User newUser ) {
		return userRepo.save(newUser);
	}
	
	// * READ ALL - Uses repo's findAll() to return all users from db.
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}
	
	// * READ ONE - Returns specific user if exists, otherwise send back null.
	public User getUserById( Long id ) {
		return userRepo.findById(id).orElse(null);
	}
	
	// * UPDATE - Search for existing tweet by primary key and appies changes.
	public User updateUser( User updatedUser ) {
		return userRepo.save(updatedUser);
	}
	
	// * DELETE - Deletes existing expense by primary key.
	public void deleteUserById( Long id ) {
		userRepo.deleteById(id);
	}
}
