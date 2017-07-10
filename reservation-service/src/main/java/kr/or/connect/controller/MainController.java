package kr.or.connect.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import kr.or.connect.service.*;

@Controller
@RequestMapping("/main")
public class MainController {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping
	public String main(Model model) {
		model.addAttribute("categories", categoryService.getAll());
		return "mainpage";
	}

}
