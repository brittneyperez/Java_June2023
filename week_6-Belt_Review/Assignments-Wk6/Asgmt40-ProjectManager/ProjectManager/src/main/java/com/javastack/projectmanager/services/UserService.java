package com.javastack.projectmanager.services;

import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.javastack.projectmanager.models.User;
import com.javastack.projectmanager.repositories.UserRepository;
import com.javastack.projectmanager.validators.LoginUser;

@Service
public class UserService {
	
	@Autowired
	private UserRepository uRepo;
	
// * Method 1: Find an existing user.
	public User findByUserById( Long id ) {
		User existingUser = uRepo.findById(id).orElse(null);
		return existingUser;
	}
	
// * Method 2: Validate registering user's age before registerUser():
	private void validateAge(User newUser, BindingResult result) {
		LocalDate currentDate = LocalDate.now();
		LocalDate dateOfBirth = newUser.getDateOfBirth();
		if (dateOfBirth != null) {
			int age = Period.between(dateOfBirth, currentDate).getYears();
			if (age < 10) {
				result.rejectValue("dateOfBirth", "InvalidAge", "You must be at least 10 years old to register.");
			}
		}
	} 
	
// * Method 3: Check credentials of registering user with an existing user and send back validations before registering them (saving them to db).
	public User registerUser( User newUser, BindingResult result ) {
		
		// 1 Find in db if the email binded to form already exists, otherwise accept it:
		Optional<User> potentialUser = this.uRepo.findByEmail(newUser.getEmail());
		if (potentialUser.isPresent()) {
			result.rejectValue("email", "Matches", "Email is already registered. Please either choose another one or log in.");
		}
		
		// 2 Perform password matching validation:
		potentialUser = this.uRepo.findByUsername(newUser.getUsername());
		if (potentialUser.isPresent()) {
			result.rejectValue("username", "Taken", "Username is already taken.");
		}
		
		// 3 Perform age validation:
		validateAge(newUser, result);
		
		// 4 Return "null" if any errors exist so the controller can present them in the front-end:
		if (result.hasErrors()) {			
			return null;
		}
		
		// 5 If everything is valid, hash and set password to save user to db:
		String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		newUser.setPassword(hashed);
		User completeRegistration = this.uRepo.save(newUser);
		return completeRegistration;
	}
		
	// * Method 4: Check credentials of potential user with existing users, send back validations if not valid, and let them login if they are.
	public User loginUser( LoginUser newLoginObject, BindingResult result ) {
		// 1 Assuming loginCredential (email/username) exists in the db (binded to the form), search the potential user:
		String loginCredential = newLoginObject.getLoginCredential();
		Optional<User> potentialUser;
		// 2 Find the email in db based on the results binded to form and reject, otherwise accept:
		potentialUser = this.uRepo.findByEmail(loginCredential);
		if (potentialUser.isPresent()) {
			User user = potentialUser.get(); // retrieve all User data to use for validations.
			if ( !BCrypt.checkpw(newLoginObject.getPassword(), user.getPassword()) ) {
				result.rejectValue("password", "Matches", "Invalid credentials.");
			}
			return user;
		} // ...if not with email...
		// 3 Find the username in db based on the results binded to form and reject, otherwise accept:
		potentialUser = this.uRepo.findByUsername(loginCredential);
		if (potentialUser.isPresent()) {
			User user = potentialUser.get(); // retrieve all User data to use for validations.
			if ( !BCrypt.checkpw(newLoginObject.getPassword(), user.getPassword()) ) {
				result.rejectValue("password", "Matches", "Invalid credentials.");
			}
			return user;
		}
		// 4 Return "null" if any errors exist so the controller can present them in the front-end:
		result.rejectValue("loginCredential", "Matches", "Invalid credentials");
		return null;
	}
}