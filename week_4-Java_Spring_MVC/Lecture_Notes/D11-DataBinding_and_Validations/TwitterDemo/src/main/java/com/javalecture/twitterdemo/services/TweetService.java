package com.javalecture.twitterdemo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javalecture.twitterdemo.models.Tweet;
import com.javalecture.twitterdemo.repositories.TweetRepository;

@Service
public class TweetService {
	
	// Connection to Repository from Service - add TweetRepository as a dependency
	/* Format:
	 	private final <<RepoName>> <<variableName>>;
	 	public <<ServiceName>> (<<RepoName>> <<paramVariableName>>) {
	 		this.<<variableName>> = <<variableName>>;
	 	} 
	 	
	 	Example:
		private final TweetRepository twtRepo;
		public TweetService( TweetRepository twtRepo) {
			this.twtRepo = twtRepo;
		}
	*/
	
	// This a shorthand version of doing the above:
	@Autowired // 
	private TweetRepository twtRepo;
	
	// * CREATE - Method 1: Takes in Tweet object and saves it to db.
	public Tweet create( Tweet newTweet ) {
		//			  .save() comes from the functionality in CrudRepository
		return twtRepo.save(newTweet);
	}
	
	// * READ ALL - Method 2: Uses repo's findAll() to return all tweets from db. 
	public List<Tweet> getAll() {
		return twtRepo.findAll();
	}
	
	// * READ ONE - Method 3: Returns seached tweet if exists, otherwise send back null.
	/* Using Optional:
		public Tweet findTweet( Long id ) {
			Optional<Tweet> optionalTweet = twtRepo.findById(id);
			if (optionalTweet.isPresent()) {
				return optionalTweet.get();
			} else {
				return null;
			}
		}
	*/
	// This is shorthand for the Optional Obj method above:
	public Tweet getById( Long id ) {
		return twtRepo.findById(id).orElse(null);
	}
	
	// * UPDATE - Method 4: Searches for existing tweet by primary key and applies changes.
	public Tweet update( Tweet updatedTweet ) {
		return twtRepo.save(updatedTweet);
	}
	
	// * DELETE - Method 5: Deletes existing expense by primary key.
	public void deleteById( Long id ) {
		twtRepo.deleteById(id);
	}
}
