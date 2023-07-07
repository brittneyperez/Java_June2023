package com.javalecture.twitterdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
public class TwitterDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TwitterDemoApplication.class, args);
	}
	
	@RequestMapping("/")
	public String index() {
		return "redirect:/tweets";
	}
}
