package com.javalecture.twitterdemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public Tweet createObject(
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
	public Tweet showOneObject( @PathVariable("tweetId") Long id ) {
		return twtService.getById(id);
	}
	
	// * UPDATE
	@PutMapping("/update/{tweetId}")
	public String updateObject(
			@PathVariable("tweetId") Long idToUpdate,
			@RequestParam(value="tweetContent", required=false) String tweetContent,
			@RequestParam(value="imaginaryIntAtt", required=false) Integer imaginaryIntAtt
			) {
		Tweet tweetToUpdate = twtService.getById(idToUpdate);
		System.out.println(tweetToUpdate.getId());
//		tweetToUpdate.setTweetContent(tweetContent);
		tweetToUpdate.setTweetContent(tweetContent != null? tweetContent: tweetToUpdate.getTweetContent());
		tweetToUpdate.setImaginaryIntAtt(imaginaryIntAtt != null? imaginaryIntAtt: tweetToUpdate.getImaginaryIntAtt());
		System.out.println(this.twtService.update(tweetToUpdate)); // com.javalecture.twitterdemo.models.Tweet@3ec2a12a
		return "";
	}
	
	// * DELETE
	@DeleteMapping("/delete/{tweetId}")
	public void deleteObject( @PathVariable("tweetId") Long tweetToDelete ) {
		System.out.println(tweetToDelete);
		this.twtService.deleteById(tweetToDelete);
	}
}
