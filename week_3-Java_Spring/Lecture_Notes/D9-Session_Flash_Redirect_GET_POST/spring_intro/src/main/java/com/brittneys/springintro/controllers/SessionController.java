package com.brittneys.springintro.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/counting")
public class SessionController {
	
	@GetMapping("")
	public String index(HttpSession session, Model model) {
		model.addAttribute("userId", 88); //? hardcoded value for pretendRedirect example
		//* ① Flow of Data: This value is defined here and can now be found in "counter.jsp".
		
		// model.addAttribute("count", 88); //? hardcoded value.
		/* Note: How to increment sessionValue?
		* session.setAttribute("count", sessionValue);
			? This stays as our set int. See below on how to increment.
			Session stores a value as an ambiguous object, so we need
			to let know that this object we are manipulating data for is
			coming back to us in session as the wrapper class, Integer.
		 */
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}
		session.setAttribute( "count", (Integer) session.getAttribute("count") + 1 );			
		return "counter.jsp";
	}
	

	@PostMapping("/clear") // the route the form's "action" will reroute to clear session
	public String clearSession(HttpSession session) {
	    // session.invalidate();
	    session.removeAttribute("count");
	    return "redirect:/counting"; // redirect only to GET maps, not POST
	}
	
	//* ③ Flow of Data: the value is then caught here, and is used in out method below.
	@PostMapping("/increment/{userId}") // we can use a different pathVariable name instead of using "userId" in counter.jsp, only in CRUD it needs to be "id"
	public String incrementBy(
			@RequestParam(value="playerName") String playerName,
			@RequestParam(value="amount", required=false) Integer amountToIncrement,
			HttpSession session,
			RedirectAttributes flash,
			@PathVariable("userId") Integer incomingId
		) {
		System.out.printf("Name: %s - Chosen Number: %s\n", playerName,  amountToIncrement);
		session.setAttribute("currentUser", playerName);
		
		if (amountToIncrement == null) {
			// create an error message and add it to flash attributes
			flash.addFlashAttribute("amountError", "Please provide an amount to increment by!!!"); // objectName: message string
			// redirect to the original form that supplied the error
			return "redirect:/counting";
		}
		session.setAttribute( "count", (Integer) session.getAttribute("count") + (amountToIncrement - 1) );
		// return "redirect:/counting/pretendRedirect/"+ incomingId; // one way to return a redirect route
		// return "redirect:/counting/pretendRedirect/{userId}"; // another way to return a redirect route, ONLY if its the same value that is used in the method's route
	    return String.format("redirect:/counting/pretendRedirect/%s", incomingId); //* ④ Flow of Data: value passed into this method is used here, to be the incoming localVariable later
	}
	
	@GetMapping("/pretendRedirect/{newPathVar}") //* ⑤ Flow of Data: The value is redirected here in the route where we print this value
	public String redirectMethod( @PathVariable("newPathVar") Integer localVariable ) {
		System.out.println("In redirect method.");
		System.out.println(localVariable); // this will print the variable we have in line20
		return "redirect:/counting";
	}
}
