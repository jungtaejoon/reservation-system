package connect.reservation.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import connect.reservation.domain.Category;
import connect.reservation.service.CategoryService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	CategoryService categoryService;
	
	
	@RequestMapping(value="/viewCategory", method=RequestMethod.GET)
	public ModelAndView viewCategory(HttpServletRequest request){
		ModelAndView model = new ModelAndView();
		
		List<Category> list = new ArrayList<Category>();
		list = categoryService.getAll();
		
		model.addObject("category", list);
		model.setViewName("category");
		
		return model;
	}
	
	@RequestMapping(value="/addNewCategory", method=RequestMethod.POST)
	public String newCategory(HttpServletRequest request) {
		categoryService.addCategory(request.getParameter("newCategory"));
		
		return "redirect:/admin/viewCategory";
	}
	
	@ResponseBody
	@RequestMapping(value="/deleteCategory/{cateSeq}", method=RequestMethod.POST)
	public String deleteCategory(HttpServletRequest request, @PathVariable int cateSeq) {
		categoryService.deleteById(cateSeq);
		
		return "Success";
	}
	
	@RequestMapping(value="/updateCategory", method=RequestMethod.POST)
	public String updateCategory(HttpServletRequest request) {
		categoryService.updateById(request);
		
		return "redirect:/admin/viewCategory";
	}
}
