package com.javalecture.loginregistration.validators;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class LoginUser {
	
	// * MEMBER VARIABLES
	@NotEmpty(message = "Email is required.")
	@Email(message = "Please enter a valid email address.")
	private String email;
	
//	@NotEmpty(message = "Email/Username is required.")
//	private String username;
	
	@NotEmpty(message = "Password is required.")
	@Size(min = 8, max = 128, message = "Must be at least 8 characters.")
	private String password;
	
	
	// * CONSTRUCTORS
	public LoginUser() {}
	
	
	// * GETTERS & SETTERS
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
//	public String getUsername() {
//		return username;
//	}
//	public void setUsername(String username) {
//		this.username = username;
//	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
