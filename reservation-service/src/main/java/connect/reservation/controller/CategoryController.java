package connect.reservation.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import connect.reservation.domain.Category;
import connect.reservation.service.CategoryService;

@Controller
@RequestMapping("/category")
public class CategoryController {
	@Autowired
	CategoryService categoryService;
	
	@GetMapping(value="/viewCategory")
	public String viewAll(Model model){
		
		List<Category> list = new ArrayList<Category>();
		list = categoryService.getAll();
		
		model.addAttribute("category", list);
		
		return "category";
	}
	
	@PostMapping(value="/addNewCategory")
	public String add(HttpServletRequest request) {
		categoryService.addCategory(request.getParameter("newCategory"));
		
		return "redirect:/admin/viewCategory";
	}
	
	@ResponseBody
	@PostMapping(value="/removeCategory/{cateSeq}")
	public String delete(@PathVariable int cateSeq) {
		categoryService.deleteById(cateSeq);
		
		return "Success";
	}
	
	@PostMapping(value="/setCategory")
	public String update(HttpServletRequest request) {
		String newCategory = request.getParameter("newCategory");
		int id = Integer.parseInt(request.getParameter("cateId"));
		categoryService.updateById(newCategory, id);
		
		return "redirect:/admin/viewCategory";
	}
}
