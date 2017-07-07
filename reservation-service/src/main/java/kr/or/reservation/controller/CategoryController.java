package kr.or.reservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import kr.or.reservation.domain.Category;
import kr.or.reservation.service.CategoryService;


@Controller
public class CategoryController {
	
	@Autowired
	CategoryService catergoryservice;
	
    @GetMapping(path = "/")
    public ModelAndView selectAll(Model model){
    	ModelAndView mav = new ModelAndView("category");
    	List<Category> list = catergoryservice.selectforList();
    	mav.addObject("list",list);
    	return mav;
    }
    
    @PostMapping(path = "/")
    public String insert(Model model,@RequestParam String name){
    	ModelAndView mav = new ModelAndView("category");
    	Category category = new Category(name);
    	catergoryservice.insert(category);
    	return "redirect:/";
    }
    
    
    @DeleteMapping(path = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") long id){
    	catergoryservice.deleteById(id);
    }
    
    @PutMapping(path = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@PathVariable("id") long id, @RequestBody Category category){
    	catergoryservice.update(category);
    }
 



}