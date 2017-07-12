package kr.or.connect.reservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.reservation.domain.Category;
import kr.or.connect.reservation.service.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryRestController {

	@Autowired
	CategoryService service;

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	int deleteCategory(@PathVariable("id") Long id) {
		return service.delete(id);
	}
	
	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	int updateCategory(@RequestBody Category category) {
		return service.update(category);
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	List<Category> getAllCategory() {
		return service.getAllCategory();
	}
}
