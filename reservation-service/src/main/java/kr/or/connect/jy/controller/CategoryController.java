package kr.or.connect.jy.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import kr.or.connect.jy.dto.Category;
import kr.or.connect.jy.service.CategoryService;

@RestController
@RequestMapping("/category/admin")
public class CategoryController {
	private CategoryService categoryService;
	
	@Autowired
	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	@PostMapping("/insert")
	public ModelAndView insert(Category category) {
		categoryService.insert(category);
		return new ModelAndView("redirect:/category/admin");
	};
	
	@GetMapping
	public ModelAndView selectAll(HttpServletRequest req, HttpServletResponse res){
		ModelAndView mav = new ModelAndView("category");
		mav.addObject("categories", categoryService.selectAll());
		return mav;
	};
	
	@PostMapping("/update")
	public String update(@ModelAttribute Category category, HttpServletRequest request) {
		if(category != null) {
			categoryService.update(category);
		}
		return "redirect:/category/admin";
	};

	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable Integer id) {
		if(id != null) {
			categoryService.delete(id);
		}
		return "redirect:/category/admin";
	};
}
