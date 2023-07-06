package com.javalecture.twitterdemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
	@PostMapping("/post/tweet")
	public String createTweet(
			@Valid @ModelAttribute("tweet") Tweet newTweet,
			BindingResult result, Model model
			) {
		if (result.hasErrors()) {
			List<Tweet> allTweets = twtService.getAll();
			model.addAttribute("tweets", allTweets);
			return "index.jsp";
		}
		twtService.create(newTweet);
		return "redirect:/tweets";
	}
	
	// * READ ONE
	// * UPDATE
	// * DELETE
}
