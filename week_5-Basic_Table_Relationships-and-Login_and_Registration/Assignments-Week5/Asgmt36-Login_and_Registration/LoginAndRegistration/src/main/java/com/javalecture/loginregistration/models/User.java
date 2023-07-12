package com.javalecture.loginregistration.models;

//import java.time.LocalDate;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
//import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {
	// * MEMBER VARIABLES
	// * BASIC CLASS OBJECT ATTRIBUTES ------------
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="MM/dd/yyy HH:mm:ss")
	private Date createdAt;
	@DateTimeFormat(pattern="MM/dd/yyy HH:mm:ss")
	private Date updatedAt;
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	
	// * OBJECT SPECIFIC ATTRIBUTES ---------------
	@NotEmpty(message = "First Name is required.")
	@Size(min = 3, message = "Must be at least 2 characters.")
	private String firstName;
	
	@NotEmpty(message = "Last Name is required.")
	@Size(min = 3, message = "Must be at least 2 characters.")
	private String lastName;
	
	@NotEmpty(message = "Email is required.")
	@Email(message = "Please enter a valid email address.")
	private String email;
	
	@NotEmpty(message = "Username is required.")
	@Size(min = 3, message = "Must be at least 3 characters.")
	@Pattern(regexp = "^[a-zA-Z0-9_]+$", message = "Username can only contain letters, numbers, and underscores.")
	@Column(unique = true)
	private String username;
	
	@NotEmpty(message = "Password is required.")
	@Size(min = 8, max = 128, message = "Must be at least 8 characters.")
	private String password;
	
	@Transient
	@NotEmpty(message = "Confirm Password is required.")
	@Size(min = 8, max = 128, message = "Must be at least 8 characters.")
	private String confirmPassword;
	
//	@NotNull(message = "Date of Birth is required.")
//	private LocalDate dateOfBirth; // date picker
//	
//	@NotNull(message = "Reasons for Applying is required.")
//	private String reasonsForApplying; // checkbox
//	
//	@NotNull(message = "Coding experience is required.")
//	private String codingExperience; // radio
//	
//	@NotNull(message = "Please provide your favorite programming language.")
//	private String favoriteLanguage; // dropdown
	
	
	// * TABLE RELATIONSHIP ATTRIBUTES ------------ n/a
	
	
	// * CONSTRUCTORS -----------------------------
	public User() {}
	public User( String firstName, String lastName, String email, String username, String password, String confirmPassword
			/* LocalDate dateOfBirth, String reasonsForApplying, String codingExperience, String favoriteLanguage */
			) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
		this.password = password;
		this.confirmPassword = confirmPassword;
//		this.dateOfBirth = dateOfBirth;
//		this.reasonsForApplying = reasonsForApplying;
//		this.codingExperience = codingExperience;
//		this.favoriteLanguage = favoriteLanguage;
	}
	// * GETTERS & SETTERS ------------------------
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
//	public LocalDate getDateOfBirth() {
//		return dateOfBirth;
//	}
//	public void setDateOfBirth(LocalDate dateOfBirth) {
//		this.dateOfBirth = dateOfBirth;
//	}
//	public String getReasonsForApplying() {
//		return reasonsForApplying;
//	}
//	public void setReasonsForApplying(String reasonsForApplying) {
//		this.reasonsForApplying = reasonsForApplying;
//	}
//	public String getCodingExperience() {
//		return codingExperience;
//	}
//	public void setCodingExperience(String codingExperience) {
//		this.codingExperience = codingExperience;
//	}
//	public String getFavoriteLanguage() {
//		return favoriteLanguage;
//	}
//	public void setFavoriteLanguage(String favoriteLanguage) {
//		this.favoriteLanguage = favoriteLanguage;
//	}
}
