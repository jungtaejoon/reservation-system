package kr.or.connect.jy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import kr.or.connect.jy.dto.Category;
import kr.or.connect.jy.service.CategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryAPIController {
	private CategoryService categoryService;
	
	@Autowired
	public CategoryAPIController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	@PostMapping
	public ModelAndView insert(@ModelAttribute Category category) {
		categoryService.insert(category);
		return new ModelAndView("redirect:/category/admin");
	};
	
	@PutMapping("/{id}")
	public void update(@PathVariable Integer id, @RequestBody Category category) {
		if(category != null) {
			category.setId(id);
			categoryService.update(category);
		}
	};

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		if(id != null) {
			categoryService.delete(id);
		}
	};
}
