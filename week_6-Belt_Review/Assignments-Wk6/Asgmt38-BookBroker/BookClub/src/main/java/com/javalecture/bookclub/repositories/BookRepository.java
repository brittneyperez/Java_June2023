package com.javalecture.bookclub.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javalecture.bookclub.models.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
	// Retrieve all books from db:
	List<Book> findAll();
}
