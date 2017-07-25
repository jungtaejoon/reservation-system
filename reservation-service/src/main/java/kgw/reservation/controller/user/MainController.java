package kgw.reservation.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kgw.reservation.service.CategoryService;
import kgw.reservation.service.ProductService;

@Controller
@RequestMapping("/")
public class MainController {
	@Value("${USER_DIR}")
	private String DIRNAME;
	private CategoryService categoryService;

	@Autowired
	public MainController(CategoryService categoryService, ProductService productService) {
		this.categoryService = categoryService;
	}
	@RequestMapping
	public String index(Model model) {
		model.addAttribute("categoryList", categoryService.find());
		return DIRNAME+"/mainpage";
	}
}
