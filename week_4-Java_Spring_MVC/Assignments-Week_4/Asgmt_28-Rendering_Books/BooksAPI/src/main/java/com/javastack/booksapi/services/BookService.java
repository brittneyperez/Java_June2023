package com.javastack.booksapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.javastack.booksapi.models.Book;
import com.javastack.booksapi.repositories.BookRepository;

@Service
public class BookService {
	
	// * Connection to Repository from Service
    // adding the book repository as a dependency
    private final BookRepository bookRepository;
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    
    // Method 1: Uses BookService's method to findAll() to return all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    
    //  Method 2: Takes in book obj adn uses it to save to db/creates a book
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }
    
    // Method 3: Optional obj is used to manage null values and searches for exisiting book/retrieves a book
    public Book findBook(Long id) {
    	// Optional - wrapper class safeguards my types to maintain control over finding a book, or null if there's no book  
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    
    /* How does .save() work?
		If book being passed in has an ID already,
		then it will change the existing book, instead
		of creating a new one. 
     */
    
    // Method 4: Searches for existing book by primary key and applies changes.
    // update a book - this method pretty much looks exactly the same as the createBook() method
    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }
    
    // Method 5: Delete exisiting book by its primary key; deletes a book
    public void deleteBook(Long id) { // bc DELETE is not supposed to return something that will no longer exists, we just perfom the action
    	bookRepository.deleteById(id);
    }
}