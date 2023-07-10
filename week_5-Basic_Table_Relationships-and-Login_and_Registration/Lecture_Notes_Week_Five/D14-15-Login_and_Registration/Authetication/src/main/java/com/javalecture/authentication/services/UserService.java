package com.javalecture.authentication.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.javalecture.authentication.models.User;
import com.javalecture.authentication.repositories.UserRepository;
import com.javalecture.authentication.validators.LoginValidator;

@Service // besides defining this file as a service, this also lets us use @Autowire in other files.
public class UserService {
	
	// Connection to Repository from Service - add UserRepository as a dependency:
	/* Longhand Format:
		private final <<RepoName>> <<variableName>>;
		public <<ServiceName>> (<<RepoName>> <<paramVariableName>>) {
			this.<<variableName>> = <<variableName>>;
		} 
		
		Example:
		private final UserRepository urepo;
		public UserService( UserRepository uRepo ) {
			this.uRepo = uRepo;
		}
	*/
	@Autowired
    private UserRepository uRepo;
    
	// READ ONE
	public User findUserById( Long id ) {
		User existingUser = uRepo.findById(id).orElse(null);
		return existingUser;
	}
	
	// REGISTER - This method will be called from the controller whenever a user submits a registration form.
	public User registerUser(
			User newUser, BindingResult result
			) {
		// ? This will in the db for the email the registering user inputted in the form  
		Optional<User> potentialUser = uRepo.findByEmail(newUser.getEmail());
		if (potentialUser.isPresent()) {
			// Reject if email is taken (present in db)
			//	Fields:		String field	String errorCode	String defaultMessage
			result.rejectValue("email", "Matches", "Email is already registered. Please either choose another or log in.");
		}
		
		// Reject if password doesn't match confimation
		//		compares values of password and confirmPassword
		if ( !newUser.getPassword().equals(newUser.getConfirmPassword()) ) {
			result.rejectValue("confirmPassword", "Matches", "Passwords must match.");
		}
		
		// Return null if result has errors
		if (result.hasErrors()) {
			return null;
		}
		
		// Hash and set password, save user to db
		String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		newUser.setPassword(hashed);
		User completeRegistration = uRepo.save(newUser);
		return completeRegistration;
	}
    
	// * LOGIN - Explanation below:
	/*　❷ If this user indeed exists, then convert that into a User obejct to 
	compare the credentials inputted to what's in saved in the db. Then, password
	validations will be performed before finally letting the potentialUser in. */ 
	public User loginUser(
			LoginValidator newLoginObject,
			BindingResult result
			) {
		// Find User by email in the db, otherwise Reject.
		Optional<User> potentialUser = uRepo.findByEmail(newLoginObject.getEmail());
		if ( potentialUser.isPresent() ) { // Reject email if not present in db.
			User user = potentialUser.get(); 
			if (!BCrypt.checkpw( newLoginObject.getPassword(), user.getPassword() )) {
				result.rejectValue("email", "Matches", "Invalid email/password.");
			}
			return user;
		} else { // Return null if result has errors.
			result.rejectValue("email", "Matches", "Invalid email/password.");
			return null;
		}
	}
}
