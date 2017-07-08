package connect.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import connect.reservation.service.CategoryService;

@Controller
@RequestMapping("/")
public class MainController {
	@Autowired
	CategoryService categoeyService;
	
	@GetMapping
	public String index() {
		return "index";
	}
}
