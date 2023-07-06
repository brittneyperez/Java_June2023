package com.javalecture.twitterdemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javalecture.twitterdemo.models.Tweet;
import com.javalecture.twitterdemo.services.TweetService;

@RestController
@RequestMapping("/api/tweets")
public class TweetApiController {
	
	@Autowired
	private TweetService twtService;
	
	// * CREATE
	@PostMapping("/create")
	public Tweet createTweet(
			@RequestParam("tweetContent") String tweetContent,
			@RequestParam("imaginaryIntAtt") Integer imaginaryIntAtt
			) {
		Tweet tweetData = new Tweet(tweetContent, imaginaryIntAtt);
		System.out.println("Tweet: " + tweetContent);
		System.out.println("Imaginary Int Attribute: " + imaginaryIntAtt);
		return twtService.create(tweetData);
	}
	// * READ ALL
	@GetMapping("")
	public List<Tweet> index() {
		return twtService.getAll();
	}
	
	// * READ ONE
	@GetMapping(value="/{tweetId}")
	public Tweet showOneTweet( @PathVariable("tweetId") Long id ) {
		return twtService.getById(id);
	}
	
	// * UPDATE
	// * DELETE
	
}
