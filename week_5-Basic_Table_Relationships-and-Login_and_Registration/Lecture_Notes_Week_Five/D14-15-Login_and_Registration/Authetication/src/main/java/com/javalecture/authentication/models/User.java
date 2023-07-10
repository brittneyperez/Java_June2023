package com.javalecture.authentication.models;

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
import jakarta.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {
	
	// * BASIC CLASS OBJECT ATTRIBUTES ------------ aka Member Variables
	// these variables need to match with the paths in the form:form 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="MM/dd/yyyy HH:mm:ss")
	private Date createdAt;
	@DateTimeFormat(pattern="MM/dd/yyyy HH:mm:ss")
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
	/* Validation Annotations:
		@NotNull : Will accept empty fields as they default to an empty String.
		@NotEmpty : Will not accept empty fields, ensures that the String length is greater than 0.
		@NotBlank : Will not accept empty fields, trims trailing spaces, then checks String length.
	*/
	@NotEmpty(message = "First Name is required.")
	@Size(min=2,max=45, message = "First Name must be between 2 and 45 characters.")
	private String firstName;
	
	@NotEmpty(message = "Last name is required.")
	@Size(min=2,max=45, message = "Last Name must be between 2 and 45 characters.")
	private String lastName;
	
	@NotEmpty(message = "Email is required.")
	@Email(message="Please enter a valid email")
	private String email;
	
	@NotEmpty(message = "Password is required.")
	@Size(min=8,max=128, message = "Password must be between 8 and 128 characters.")
	private String password;
	
	@Transient // this will not save the info, it will only validate.
	@NotEmpty(message = "Confirm Password is required.")
	@Size(min=8,max=128, message = "Confirm Password must be between 8 and 128 characters.")
	private String confirmPassword;
	
	// * TABLE RELATIONSHIP ATTRIBUTES ------------
	
	
	// * CONSTRUCTORS -----------------------------
	public User() {} // empty constructor
	public User( String firstName, String lastName, String email, String password, String confirmPassword ) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
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
}
