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
	CategoryServiceImpl categoryService;
	
	@GetMapping
	public List<Category> getAll() {
		return categoryService.getAll();
	}
	
	@PostMapping
	public void insert(@RequestParam Category category) {
		categoryService.insertCategory(category);
	}

}
