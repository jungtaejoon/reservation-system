package kr.or.connect.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import kr.or.connect.domain.*;
import kr.or.connect.service.*;

@RestController
@RequestMapping("/categories")
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	@GetMapping
	public List<Category> getAll() {
		return categoryService.getAll();
	}
	
	@PostMapping
	public void insert(@RequestBody Category category) {
		categoryService.insertCategory(category);
	}

}
