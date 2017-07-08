package kjh.reservation.controller;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kjh.reservation.domain.Category;
import kjh.reservation.service.CategoryService;

@Controller
@RequestMapping("/categorys")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/list")
	public String list(HttpServletRequest request) {
		Collection<Category> list = categoryService.getAll();
		request.setAttribute("listInfo", list);
		return "mainPage";
	}
	
	@GetMapping("/update")
	public String update(@ModelAttribute Category categoryParam) {
		Category category = new Category();
		category.setId(categoryParam.getId());
		category.setName(categoryParam.getName());
		int updated = categoryService.update(category);
		if(updated != 0) {
			System.out.println("updated");
		} else {
			System.out.println("not updated");
		}
		return "redirect:/categorys/list";
	}
	
	@PostMapping
	public String create(@ModelAttribute Category categoryParam) {
		Category category = new Category();
		category.setName(categoryParam.getName());
//		Category added = categoryService.addCategory(category);
		categoryService.addCategory(category);
		return "redirect:/categorys/list";
	}
}
