package com.jamesgabbie.displaydate.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	private String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/date")
	private String date(Model model) {
		Date date = new java.util.Date();
		SimpleDateFormat sdf = new SimpleDateFormat("EEEE, 'the' d 'of' MMMM, yyyy");
		String showDate = sdf.format(date);
		model.addAttribute("date", showDate);
		return "date.jsp";
	}
	
	@RequestMapping("/time")
	private String time(Model model) {
		Date date = new java.util.Date();
		SimpleDateFormat sdf = new SimpleDateFormat("h:mm a");
		String showTime = sdf.format(date);
		model.addAttribute("time", showTime);
		
		return "time.jsp";
	}
}
