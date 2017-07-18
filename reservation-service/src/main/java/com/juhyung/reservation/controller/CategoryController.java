package com.juhyung.reservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.juhyung.reservation.domain.CategoryVO;
import com.juhyung.reservation.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@GetMapping
	public List<CategoryVO> list(Model model) throws Exception {
		return categoryService.getCategoryListAll();
	}
	
	@PostMapping
	public void create(@RequestBody String name){
		CategoryVO category = new CategoryVO();
		category.setName(name);
		categoryService.create(category);
	}
	
	//RESTFul
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) {
		categoryService.removeById(id);
	}
	
	@PutMapping("/{id}")
	public void modify(@PathVariable("id") Integer id,
			@RequestBody String name) {
		CategoryVO category = new CategoryVO();
		category.setId(id);
		category.setName(name);
		categoryService.modifyById(category);
	}
	
}
