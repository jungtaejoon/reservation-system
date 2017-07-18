package kr.or.connect.jy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.connect.jy.service.CategoryService;

@Controller
@RequestMapping("/category/admin")
public class CategoryController {
	private CategoryService categoryService;

	@Autowired
	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@GetMapping
	public String categoryAdmin(Model model) {
		model.addAttribute("categories", categoryService.selectAll());
		return "category";
	}
}
