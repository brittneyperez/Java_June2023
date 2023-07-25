package com.javastack.projectmanager.validators;

import jakarta.validation.constraints.NotEmpty;

public class LoginUser {
	
	// * MEMBER VARIABLES -------------------------
	@NotEmpty(message = "Email/Username is required.")
	private String loginCredential;
	
	@NotEmpty(message = "Password is required")
	private String password;
	
	
	// * CONSTRUCTORS -----------------------------
	public LoginUser() {}
	
	// * GETTERS & SETTERS ------------------------
	public String getLoginCredential() {
		return loginCredential;
	}
	public void setLoginCredential(String loginCredential) {
		this.loginCredential = loginCredential;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}