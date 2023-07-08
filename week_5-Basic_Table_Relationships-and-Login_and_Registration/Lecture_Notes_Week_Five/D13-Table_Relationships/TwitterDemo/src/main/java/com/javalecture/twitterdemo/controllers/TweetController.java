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
import com.javalecture.twitterdemo.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/tweets")
public class TweetController {
	
	@Autowired
	private TweetService twtService;
	@Autowired
	private UserService uService;
	
	// * READ ALL
	@GetMapping("")
	public String index(
			@ModelAttribute("newTweet") Tweet newTweet,
			Model model, HttpSession session
			) {
		// Short-hand Version:
		model.addAttribute("tweets", this.twtService.getAll());
		/* Long-hand Version: 
			List<Tweet> allTweets = twtService.getAll();
			model.addAttribute("tweets", allTweets);
		*/
		
		Long pseudoUserId = (long) 3; // convert user_id int -> long/BigInt
		session.setAttribute("loggedInUser", pseudoUserId); // pass it in to set the primary key of current active pseudo user
		
		// * Print to Server Console All Tweets:
		List<Tweet> allTweets = twtService.getAll();
		System.out.println("\n--------------- All Tweets ---------------");
		for (int i=0; i<allTweets.size();i++) {
			Tweet singleTweet = allTweets.get(i);
			System.out.printf("%s  %s | @%s_%s #%s\n", i, singleTweet.getTweetContent(), singleTweet.getCreator().getFirstName(), singleTweet.getCreator().getLastName(), singleTweet.getImaginaryIntAtt());
			System.out.println("------------------------------------------");
		}
		return "index.jsp";
	}
	
	// * CREATE
	@PostMapping("/post")
	public String createTweet(
			@Valid @ModelAttribute("tweet") Tweet newTweet,
			BindingResult result, Model model, HttpSession session
			) {
		if (result.hasErrors()) {
			List<Tweet> allTweets = twtService.getAll();
			model.addAttribute("tweets", allTweets);
			// model.addAttribute("tweet", new Tweet()); // Since we defined this in the @ModelAttribute above, this line is not needed
			return "index.jsp";
		}
		newTweet.setCreator(this.uService.getUserById((Long)session.getAttribute("loggedInUser"))); // this will use the pseudoUserId set in the index page to post under that user_id
		System.out.println(newTweet);
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
