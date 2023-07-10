package com.javalecture.authentication.validators;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class LoginValidator {
	
	/*  LoginValidator can be referred as a helper class, 
		meaning that its a class used to modularize any group
		of functionalities that don't need to be in the database
		as it won't need an @Entity, or table name.
		We just want the fields available and for it to act like
		a @Transient class where it exists instead in the logic-side of
		our app, not in the persistence layer (aka the db). 
	*/
	
	// * MEMBER VARIABLES
	@NotEmpty(message = "Email is required.")
	@Email(message = "Please enter a valid email address.")
	private String email;
	
	@NotEmpty(message = "Password is required.")
	@Size(min=8, max=128, message = "Password must be between 8 and 128 characters long.")
	private String password;
	
	
	// * CONSTRUCTOR
	public LoginValidator() {}
	
	
	// * GETTERS & SETTERS
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}