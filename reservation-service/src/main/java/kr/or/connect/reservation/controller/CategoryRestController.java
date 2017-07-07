package kr.or.connect.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.reservation.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryRestController {

	@Autowired
	CategoryService service;

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	int deleteCategory(@PathVariable("id") Long id) {
		return service.delete(id);
	}
}
