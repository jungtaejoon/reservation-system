package kr.or.connect.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.connect.reservation.service.CategoryService;

@Controller
@RequestMapping("/")
public class MainController {
	@Autowired
	private CategoryService service;
	
	@GetMapping
	public String index(Model model) {
		model.addAttribute("categories", service.getAllCategory());
		return "index";
	}
}