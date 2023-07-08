package com.javalecture.twitterdemo.models;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {
	
	// * BASIC CLASS OBJECT ATTRIBUTES ------------
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
	@NotBlank(message = "First Name is required")
	@Size(min=2, message = "Must be a minimum of 2 characters")
	private String firstName;
	
	@NotBlank(message = "Last Name is required")
	@Size(min=2, message = "Must be a minimum of 2 characters")
	private String lastName;
	
	@NotBlank(message = "Field required")
	private String email;
	
	@NotBlank(message = "Field required")
	private String password;
	
	// * TABLE RELATIONSHIP ATTRIBUTES ------------
	// ? One-to-One
	// @OneToOne(mappedBy="posterName", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	// private Tweet myTweet;
	
	// ? One-to-Many: One User has many Tweets
	@OneToMany(mappedBy="creator", fetch=FetchType.LAZY) // FetchType.LAZY = don't retrieve data unless asked for it
	private List<Tweet> myTweets;
	
	// * CONSTRUCTORS -----------------------------
	public User() {} // empty constructor
	public User( String firstName, String lastName, String email, String password ) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
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
	public List<Tweet> getMyTweets() {
		return myTweets;
	}
	public void setMyTweets(List<Tweet> myTweets) {
		this.myTweets = myTweets;
	}
}
