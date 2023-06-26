package com.javastack.displaydate.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class DateTimeController {

//	@RequestMapping("/test")
//	public String test() {
//		return "Hello World!";
//	}
	
	@RequestMapping("")
	public String index() {
		return "home.jsp";
	}
	
	@RequestMapping("/date")
	public String displayDate(Model model) {
		Date date = new Date();
		System.out.println(date); // Mon Jun 26 17:24:14 EDT 2023
		
		SimpleDateFormat simplifiedDate = new SimpleDateFormat("EEEE, MMM d, yyyy");
		model.addAttribute("date", simplifiedDate.format(date));
		System.out.println(simplifiedDate.format(date)); // Monday, Jun 26, 2023
		return "date.jsp";
	}
	
	@RequestMapping("/time")
	public String displayTime(Model model) {
		Date time = new Date();
		System.out.println(time); // Mon Jun 26 17:34:30 EDT 2023
		
		SimpleDateFormat simplifiedTime = new SimpleDateFormat("h:mm a");
		model.addAttribute("time", simplifiedTime.format(time));
		System.out.println(simplifiedTime.format(time)); // 5:34 PM
		return "time.jsp";
	}
}
