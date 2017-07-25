package com.juhyung.reservation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class HomeController {

	@GetMapping
	public String mainpage() throws Exception {
		return "mainpage";
	}

	@GetMapping("/admin")
	public String categoryEdit() throws Exception {
		return "index";
	}

	@GetMapping("/detail/{id}")
	public String readProductDeatil(@PathVariable int id, Model model) {
		model.addAttribute("id", id);
		return "detail";
	}

	@GetMapping("/review/{id}")
	public String reivew(@PathVariable int id, Model model) {
		model.addAttribute("id", id);
		return "review";
	}

	@GetMapping("/touch")
	public String touch() {
		return "touch";
	}

	@GetMapping("/myreservation")
	public String myreservation() throws Exception {
		return "myreservation";
	}
	
	@GetMapping("/reserve/{id}")
	public String reserve(@PathVariable int id, Model model) throws Exception {
		model.addAttribute("id", id);
		return "reserve";
	}
	
	@GetMapping("/naver")
	public String naver() {
		return "redirect:https://www.naver.com/";
	}
}