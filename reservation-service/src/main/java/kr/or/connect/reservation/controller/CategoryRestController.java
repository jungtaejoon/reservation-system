package kr.or.connect.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.reservation.domain.Category;
import kr.or.connect.reservation.service.CategoryService;

@RestController
@RequestMapping("/admin/api")
public class CategoryRestController {
	@Autowired
    private CategoryService categoryService;

	
	 @PutMapping
	 @ResponseStatus(HttpStatus.NO_CONTENT)
	    public void update(@RequestBody Category category) {
	        if (category == null || category.getName().length() == 0 || category.getId() < 0) {
	            
	        }else {       	     
	            categoryService.update(category); 
	        }	
	    }
	 
	 @DeleteMapping("/{id}")
	 @ResponseStatus(HttpStatus.NO_CONTENT)
	 public int delete(@PathVariable Long id){
	        return categoryService.delete(id);
	 }
}
