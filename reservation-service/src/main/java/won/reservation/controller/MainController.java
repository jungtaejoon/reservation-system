package won.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import won.reservation.service.CategoryService;

@Controller
public class MainController {
	
	private CategoryService categoryService;
		
	@Autowired
	public MainController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	@GetMapping
	@RequestMapping("/")
	public String main(Model model) {
		model.addAttribute("category", categoryService.get());
		return "mainpage";
	}
	
	@GetMapping
	@RequestMapping("/review")
	public String review() {
		return "review";
	}
	
}
