package com.javaspringmvc.jpademo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javaspringmvc.jpademo.models.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
	// This repository will allow us to perform any queries (and JPA queries) for our database.
	// As well as gives us access to full CRUD.
	
	// ? this method retrieves all the books from the database
	List<Book> findAll();
	// ? this method finds books with descriptions containing the search String (also can enable search bar usage)
	List<Book> findByDescriptionContaining(String search);
}
