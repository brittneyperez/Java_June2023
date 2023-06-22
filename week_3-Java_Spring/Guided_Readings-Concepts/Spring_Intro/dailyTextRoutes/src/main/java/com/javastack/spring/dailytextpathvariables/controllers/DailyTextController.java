package com.javastack.spring.dailytextpathvariables.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // will receive requests from the browser
@RequestMapping("/dailytext")
public class DailyTextController {
	
	@RequestMapping("")
	public String welcome() {
		return "Welcome!";
	}
	
	@RequestMapping("/today")
	public String today() {
		return "\"So never be anxious about the next day, for the next day will have its own anxieties. Each day has enough of its own troubles\".—Matthew 6:34";
	}
	
	@RequestMapping("/tomorrow")
	public String tomorrow() {
		return "\"And he will wipe out every tear from their eyes, and death will be no more, neither will mourning nor outcry nor pain be anymore. The former things have passed away.\"—Revelation 21:4";
	}
}
