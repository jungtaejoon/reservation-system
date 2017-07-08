package kr.or.connect.reservation.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import kr.or.connect.reservation.domain.Category;
import kr.or.connect.reservation.service.CategoryService;

@Controller
@RequestMapping({"/admin","/reservation-service/admin"})
public class CategoryController {
	 @Autowired
	    private CategoryService categoryService;
	 
	 @GetMapping
	    public ModelAndView index(HttpServletRequest request){
	    	
	    	List<Category> categories = categoryService.getAll();
	    	ModelAndView mv = new ModelAndView("admin", "categories", categories);
	        return mv;
	    }
	 
	 
	 
	 @PostMapping
	    public String create(String categoryName) {
	        if (categoryName == null || categoryName.length() == 0) {
	            return "redirect:/admin"; // category가 비어있을 경우 디동
	        }else {
	                Category categoryOb = new Category(categoryName);
	                Category resultCategory = categoryService.addCategory(categoryOb);

	                return "redirect:/admin"; 
	            
	        }
	    }
	 
/*	 @PutMapping
	 @ResponseStatus(HttpStatus.NO_CONTENT)
	    public void update(@RequestBody Category category) {
	        if (category == null || category.getName().length() == 0 || category.getId() < 0) {
	            
	        }else {       	     
	            categoryService.update(category); 
	        }	
	    }
	 
	 @DeleteMapping("/{id}")
	 @ResponseStatus(HttpStatus.NO_CONTENT)
	 public void delete(@PathVariable Long id){
	        categoryService.delete(id);
	 }*/
	 
	/* @PutMapping
	 @ResponseStatus(HttpStatus.NO_CONTENT)
	    public void update(@RequestBody Category category) {
	        if (category == null || category.getName().length() == 0 || category.getId() < 0) {
	            
	        }else {       	     
	            categoryService.update(category); 
	        }	
	    }*/
	 
	

}
