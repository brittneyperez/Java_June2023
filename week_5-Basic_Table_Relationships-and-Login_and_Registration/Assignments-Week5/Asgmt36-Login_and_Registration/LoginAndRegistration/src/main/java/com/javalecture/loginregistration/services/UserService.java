package com.javalecture.loginregistration.services;

import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.javalecture.loginregistration.models.User;
import com.javalecture.loginregistration.repositories.UserRepository;
import com.javalecture.loginregistration.validators.LoginUser;

@Service
public class UserService {
	
	@Autowired
	private UserRepository uRepo;
	
	// Method 1: Retrieve an existing user.
	public User findUserById( Long id ) {
		User existingUser = this.uRepo.findById(id).orElse(null);
		return existingUser;
	}
	
	// Private method to validate registeringUser's age for registerUser() method:
	private void validateAge( User newUser, BindingResult result ) {
		LocalDate currentDate = LocalDate.now();
		LocalDate dateOfBirth = newUser.getDateOfBirth();
		if (dateOfBirth != null) {
			int age = Period.between(dateOfBirth, currentDate).getYears();
			if (age < 10) {
				result.rejectValue("dateOfBirth", "InvalidAge", "You must be at least 10 years old to register.");
			}
		}
	}
	
	// Method 2: Register a user.
	public User registerUser( User newUser, BindingResult result ) {
		
		// 1 Find in db if email that is binded to the form already exists in db. If so reject it.
		Optional<User> potentialUser = uRepo.findByEmail(newUser.getEmail());
		if (potentialUser.isPresent()) {
			result.rejectValue("email", "Matches", "Email is already registered. Please either choose another one or log in.");
		}
		
		potentialUser = this.uRepo.findByUsername(newUser.getUsername());
		if (potentialUser.isPresent()) {
			result.rejectValue("username", "Taken", "Username is already taken");
		}
		
		
		// 2 Perform password matching validation.
		if ( !newUser.getPassword().equals(newUser.getConfirmPassword())) {
			result.rejectValue("confirmPassword", "Matches", "Passwords must match.");
		}
		
		// 3 Perform age validation.
		validateAge(newUser, result);
		
		// 4 Return "null" if any errors for the controller to handle validations.
		if (result.hasErrors()) {
			return null;
		}
		
		// 5 If everything is valid, hash and set password to save user to db.
		String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		newUser.setPassword(hashed);
		User completeRegistration = this.uRepo.save(newUser);
		return completeRegistration;
	}
	
	// Method 3: Login a user.
	public User loginUser( LoginUser newLoginObject, BindingResult result ) {
		
		// 1 Assuming the loginCredential is an existing email/username (binded to the form), we will search the potentialUser. 
		String loginCredential = newLoginObject.getLoginCredential();
		
		Optional<User> potentialUser;
		
		// 2 Find the email in db based on the results binded to form, otherwise reject.
		potentialUser = this.uRepo.findByEmail(loginCredential);
		if ( potentialUser.isPresent() ) {
			User user = potentialUser.get(); // Get all the data within User object.
			if ( !BCrypt.checkpw(newLoginObject.getPassword() , user.getPassword())) {
				result.rejectValue("password", "Matches", "Invalid credentials.");
			}
			return user;
		} // ...if not an email...
		// 3 Find the username in db based on the results binded to form, otherwise reject.
		potentialUser = this.uRepo.findByUsername(loginCredential);
		if ( potentialUser.isPresent() ) {
			User user = potentialUser.get();
			if ( !BCrypt.checkpw(newLoginObject.getPassword() , user.getPassword())) {
				result.rejectValue("password", "Matches", "Invalid credentials.");
			}
			return user;
		}
		
		// 4 Return "null" if any errors for the controller to handle validations. 
		result.rejectValue("loginCredential", "Matches", "Invalid credentials.");
		return null;
	}
}
