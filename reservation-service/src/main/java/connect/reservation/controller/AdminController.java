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
	CategoryService category;
	
	
	@RequestMapping(value="/viewCategory")
	public ModelAndView viewCategory(HttpServletRequest request){
		ModelAndView model = new ModelAndView();
		model = category.getAll();	
		
		return model;
	}
	
	@RequestMapping(value="/addNewCategory", method=RequestMethod.POST)
	public String newCategory(HttpServletRequest request) {
		category.addCategory(request.getParameter("newCategory"));
		
		return "redirect:/admin/viewCategory";
	}
	
	@ResponseBody
	@RequestMapping(value="/deleteCategory/{cateSeq}", method=RequestMethod.POST)
	public String deleteCategory(HttpServletRequest request, @PathVariable int cateSeq) {
		category.deleteById(cateSeq);
		
		return "redirect:/admin/viewCategory";
	}
	
	@RequestMapping(value="/updateCategory", method=RequestMethod.POST)
	public String updateCategory(HttpServletRequest request) {
		category.updateById(request);
		
		return "redirect:/admin/viewCategory";
	}
}
