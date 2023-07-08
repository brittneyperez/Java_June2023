package com.javalecture.twitterdemo.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="tweets")
public class Tweet {
	
	// * BASIC CLASS OBJECT ATTRIBUTES ------------
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date createdAt;
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date updatedAt;
	
	@PrePersist
	protected void onCreate(){
		this.createdAt = new Date();
	}
	@PreUpdate
	protected void onUpdate(){
		this.updatedAt = new Date();
	}
	
	// * OBJECT SPECIFIC ATTRIBUTES ---------------
	/* Validation Annotations:
		@NotNull : Will accept empty fields as they default to an empty String.
		@NotEmpty : Will not accept empty fields, ensures that the String length is greater than 0.
		@NotBlank : Will not accept empty fields, trims trailing spaces, then checks String length.
	*/
	
	@NotBlank(message = "Content required.")
	@Size(min = 2, max = 255, message = "Content must be over 2 characters.")
	private String tweetContent;
	
	@NotNull(message = "Integer required.")
	@Min(value=10, message = "Integer must be over 10.")
	private int imaginaryIntAtt;
	
	// * TABLE RELATIONSHIP ATTRIBUTES ------------
	// ? One-to-One
	// @OneToOne(fetch=FetchType.LAZY)
	// @JoinColumn(name="user_id")
	// private User posterName;
	
	// ? Many-to-One: Many Tweets are created by one User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User creator;
	
	// * CONSTRUCTORS -----------------------------
	public Tweet() {} // empty constructor
	public Tweet(String tweetContent, int imaginaryIntAtt) {
		this.tweetContent = tweetContent;
		this.imaginaryIntAtt = imaginaryIntAtt;
	}
	public Long getId() {
		return id;
	}
	
	// * GETTERS & SETTERS ------------------------
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
	public String getTweetContent() {
		return tweetContent;
	}
	public void setTweetContent(String tweetContent) {
		this.tweetContent = tweetContent;
	}
	public int getImaginaryIntAtt() {
		return imaginaryIntAtt;
	}
	public void setImaginaryIntAtt(int imaginaryIntAtt) {
		this.imaginaryIntAtt = imaginaryIntAtt;
	}
	public User getCreator() {
		return creator;
	}
	public void setCreator(User creator) {
		this.creator = creator;
	}
}
