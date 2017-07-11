package com.juhyung.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.juhyung.reservation.domain.CategoryVO;
import com.juhyung.reservation.service.CategoryService;

@Controller
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@GetMapping
	public String list(Model model) throws Exception {
		model.addAttribute("categories", categoryService.getCategoryListAll());
		return "index";
	}
	
	@PostMapping("/create")
	public String create(@RequestParam("name") String name){
		CategoryVO category = new CategoryVO();
		category.setName(name);
		categoryService.create(category);
		return "redirect:/category";
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("id") Integer id) {
		categoryService.removeById(id);
		return "redirect:/category";
	}
	
	@PostMapping("/modify")
	public String modify(@ModelAttribute("CategoryVO") CategoryVO category) {
		System.out.println(category.toString());
		categoryService.modify(category);
		return "redirect:/category";
	}
}
