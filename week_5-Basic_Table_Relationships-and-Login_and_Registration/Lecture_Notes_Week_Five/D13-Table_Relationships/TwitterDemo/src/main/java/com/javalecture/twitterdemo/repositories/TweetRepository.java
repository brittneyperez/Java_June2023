package com.javalecture.twitterdemo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javalecture.twitterdemo.models.Tweet;

@Repository
public interface TweetRepository extends CrudRepository<Tweet, Long> {
	// extends CrudRepository to access CRUD functionality
	
	// retrieves all tweets from db
	List<Tweet> findAll();
}
