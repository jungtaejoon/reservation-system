package kr.or.connect.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.connect.reservation.service.CategoryService;

@Controller
@RequestMapping("/")
public class MainController {
	@Autowired
	private CategoryService service;
	
	@GetMapping
	public String index() {
		return "mainpage";
	}
	
	@GetMapping("/my")
	public String myreservation() {
		return "myreservation";
	}
	
	@GetMapping("/product/{id}")
	public String detailProduct(Model model, @PathVariable("id") Long id) {
		model.addAttribute(id);
		return "detail";
	}
}