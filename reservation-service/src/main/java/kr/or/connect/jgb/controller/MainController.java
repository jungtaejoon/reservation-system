package kr.or.connect.jgb.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import kr.or.connect.jgb.domain.Category;
import kr.or.connect.jgb.service.CategoryService;

@Controller
@RequestMapping("/")
public class MainController {
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping
	public ModelAndView catergory(HttpServletRequest req,HttpServletResponse res) {
		ModelAndView mav = new ModelAndView("category");
		List<Category> categories;
		categories = categoryService.getAll();
		mav.addObject("categories", categories);
		return mav;
	}
	
	@PostMapping
    public String create(@RequestParam(name="name") String name,HttpServletRequest request) {
        Category category = new Category(name);
        categoryService.addCategory(category);
        return "redirect:/";
    }
}
