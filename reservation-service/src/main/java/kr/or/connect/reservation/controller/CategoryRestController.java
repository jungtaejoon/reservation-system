package kr.or.connect.reservation.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.reservation.domain.Category;
import kr.or.connect.reservation.service.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryRestController {

	@Autowired
	private CategoryService service;
	
	@GetMapping
	public List<Category> selectCategories() {
		List<Category> categoryList = service.selectCategoriesAll();
		
		return categoryList;
	}
	
	@DeleteMapping("/{id}")
	public void categoryDelete(@PathVariable int id) {
		service.deleteCategory(id);
	}

	@PutMapping("/{id}")
	public int categoryUpdate(@PathVariable int id, @RequestBody Category category) {
		service.updateCategory(id, category);
		return id;
	}

}
