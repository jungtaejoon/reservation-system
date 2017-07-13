package com.soomin.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.soomin.reservation.domain.Category;
import com.soomin.reservation.service.CategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryRestController {
	@Autowired
	private CategoryService categoryService;
	
	@DeleteMapping("/{id}")
	public void deleteAction(@PathVariable Long id){
		int result = categoryService.deleteCategory(id);
	}
	
	@PostMapping("/{id}")
	public void updateAction(@PathVariable Long id, @RequestBody Category category ) {
		category.setId(id);
		int result = categoryService.updateCategory(category);
	}
}
