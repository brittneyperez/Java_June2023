package com.javalecture.twitterdemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
// import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javalecture.twitterdemo.models.Tweet;
import com.javalecture.twitterdemo.services.TweetService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/tweets")
public class TweetController {
	
	@Autowired
	private TweetService twtService;
	
	// * READ ALL
	@GetMapping("")
	public String index( Model model ) {
		List<Tweet> allTweets = twtService.getAll();
		model.addAttribute("tweets", allTweets);
		model.addAttribute("tweet", new Tweet());
		
		System.out.println("\n--------------- All Tweets ---------------");
		for (int i=0; i<allTweets.size();i++) {
			Tweet singleTweet = allTweets.get(i);
			System.out.printf("%s  %s | #%s\n", i, singleTweet.getTweetContent(), singleTweet.getImaginaryIntAtt());
			System.out.println("------------------------------------------");
		}
		return "index.jsp";
	}
	
	// * CREATE
	@PostMapping("/post")
	public String createTweet(
			@Valid @ModelAttribute("tweet") Tweet newTweet,
			BindingResult result, Model model
			) {
		if (result.hasErrors()) {
			List<Tweet> allTweets = twtService.getAll();
			model.addAttribute("tweets", allTweets);
//			model.addAttribute("tweet", new Tweet()); // Add a new empty tweet to the model so it won't go to post route
			return "index.jsp";
		}
		
		if (newTweet.getTweetContent() != null && !newTweet.getTweetContent().isEmpty()) {
			twtService.create(newTweet);			
		}
		return "redirect:/tweets";
	}
	
	// * READ ONE
	
	// * UPDATE
	// rendering edit page
	@GetMapping("/{tweetId}/edit")
	public String editTweet(
			@PathVariable("tweetId") Long idToEdit,
			Model model
			) {
		model.addAttribute("tweetToEdit", twtService.getById(idToEdit));
		return "update.jsp";
	}
	// performing update functionality
	@PutMapping(value="/{id}/update") // method=RequestMethod.PUT is not needed since this is already POST mapping
	public String updateTweet(
			@Valid @ModelAttribute("tweetToEdit") Tweet editedTweet,
			BindingResult result, Model model
			) {
		if (result.hasErrors()) {
			// model.addAttribute("tweet", editedTweet);
			return "update.jsp";
		} else {
			twtService.update(editedTweet);
			return "redirect:/";
		}
	}
	
	// * DELETE
	/* Deleting via form and @DeleteMapping
	@DeleteMapping("/{tweetId}/delete")
	public String destroyMeAlternate( @PathVariable("tweetId") Long tweetId ) {
		System.out.println(tweetId);
		this.twtService.deleteById(tweetId);
		return "redirect:/";
	} */
	
	// Deleting via link and @GetMapping
	@GetMapping("/{tweetId}/delete")
	public String deleteTweet(@PathVariable("tweetId") Long tweetId) {
		System.out.println("\nDeleting tweet "+ tweetId +"...");
		this.twtService.deleteById(tweetId);
		return "redirect:/";
	}
}
