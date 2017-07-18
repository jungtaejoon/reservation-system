package kr.or.connect.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import kr.or.connect.service.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

	CategoryService categoryService;

	@Autowired
	public AdminController(CategoryService categoryService) {
		super();
		this.categoryService = categoryService;
	}

	@GetMapping
	public String admin(Model model) {
		model.addAttribute("categories", categoryService.getAll());
		return "admin";
	}

}