package com.juhyung.reservation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@GetMapping
	public String mainpage() throws Exception {
		return "mainpage";
	}
	
	@GetMapping("/admin")
	public String categoryEdit() throws Exception {
		return "index";
	}
}