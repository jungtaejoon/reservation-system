package won.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import won.reservation.domain.Category;
import won.reservation.service.CategoryService;

@Controller
@RequestMapping(value= {"/category"})
public class CategoryController {
	
	private CategoryService categoryService;
	
	@Autowired
	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	@GetMapping
	public ModelAndView read() {
		ModelAndView mav = new ModelAndView("mainpage");
		mav.addObject("category", categoryService.get());
		return mav;
	}
	
	@PostMapping
	public String create(@RequestParam String name) {
		int result = categoryService.add(name);
		return "redirect:/category";
	}
	
	@GetMapping
	@ResponseBody
	@RequestMapping("/delete")
	public String delete(@RequestParam("id") int id) {
		categoryService.remove(id);
		return "success";
	}
	
	@PostMapping
	@ResponseBody
	@RequestMapping("/update")
	public void update(@ModelAttribute("category") Category category) {
		categoryService.modify(category);
	}
	
}
