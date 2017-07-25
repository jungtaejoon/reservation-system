package kr.or.connect.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import kr.or.connect.service.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

	CategoryService categoryService;
	ProductService productService;

	@Autowired
	public AdminController(CategoryService categoryService, ProductService productService) {
		super();
		this.categoryService = categoryService;
		this.productService = productService;
	}

	@GetMapping
	public String admin(Model model) {
		model.addAttribute("categories", categoryService.getAll());
		return "admin";
	}

	@GetMapping("/products/{id:[\\d]+}")
	public String products(@PathVariable Long id, Model model) {
		model.addAttribute("productId", id);
		model.addAttribute("images", productService.getImages(id));
		return "productimageform";
	}

}