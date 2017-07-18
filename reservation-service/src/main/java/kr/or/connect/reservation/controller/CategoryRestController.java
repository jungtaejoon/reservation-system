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
@RequestMapping("/api/category")
public class CategoryRestController {
	@Autowired
    private CategoryService categoryService;
	
	 @GetMapping
	    public List<Category> get(){
	        return categoryService.getAll();
	    }
	
	 @PutMapping
	 @ResponseStatus(HttpStatus.NO_CONTENT)
	    public void update(@RequestBody Category category) {
	        if (category == null || category.getName().length() == 0 || category.getId() < 0) {
	            
	        }else {       	     
	            categoryService.update(category); 
	        }	
	    }
	 
//	 @PostMapping
//	 @ResponseStatus(HttpStatus.NO_CONTENT)
//	    public void update(@ModelAttribute Category category) {
//	        if (category == null || category.getName().length() == 0 || category.getId() < 0) {
//	            
//	        }else {       	     
//	            categoryService.update(category); 
//	        }	
//	    }
	  
	 @DeleteMapping("/{id}")
	 @ResponseStatus(HttpStatus.NO_CONTENT)
	 public void delete(@PathVariable Long id){
	        categoryService.delete(id);
	 }
}
