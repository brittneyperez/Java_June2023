package com.javastack.booksapi.models;


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
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity // ? connects class to database
@Table(name="books") // ? signifies table name in db
public class Book {
	
	// * MEMBER VARIABLES
	
	/* Validation Annotations
		@NotNull : Will accept empty fields as they default to an empty String.
		@NotEmpty : Will not accept empty fields, ensures that the String length is greater than 0.
		@NotBlank : Will not accept empty fields, trims trailing spaces, then checks String length.
	 */
	
	
	@Id // ? primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// ? meaning that this field cannot be null
	@NotBlank(message = "Title is required.")
	@Size(min = 5, max = 200, message="Title must be at least 5 characters.")
	private String title;
	
	
	@NotBlank(message = "Description is required.")
	@Size(min = 5, max = 200, message="Description must be at least 5 characters.")
	private String description;
	
	
	@NotEmpty(message="Language is required.")
	private String language;
	// @NotNull
	// @Size(min = 3, max = 40, message="Language is required.")
	// private String language;
	
	@NotNull(message="Must not be blank.")
	@Min(value=50)
	private Integer numberOfPages;
	
	
	// ? This will not allow the createdAt column to be updated after creation
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	// * CONSTRUCTORS - 2 are required, 1) for creating book w/o params, while 2) w/ params
	public Book() {
	}
	public Book(String title, String description, String lang, int numOfPages) {
		this.title = title;
		this.description = description;
		this.language = lang;
		this.numberOfPages = numOfPages;
	}

	@PrePersist
	protected void onCreate(){
		this.createdAt = new Date();
	}
	@PreUpdate
	protected void onUpdate(){
		this.updatedAt = new Date();
	}
	
	
	// * Validations METHODS
//	public String validateTitle() {
//		if (title == null || title.trim().isEmpty()) {
//			return "Title is required";
//		} else if (title.length() > 0 && title.length() < 5) {
//			return "TItle needs to be at least 5 characters.";
//		}
//		return null;
//	}
	
	
	// * GETTERS & SETTERS
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public Integer getNumberOfPages() {
		return numberOfPages;
	}
	public void setNumberOfPages(Integer numberOfPages) {
		this.numberOfPages = numberOfPages;
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
}