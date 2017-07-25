package kr.or.connect.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import kr.or.connect.service.*;

@Controller
@RequestMapping("/")
public class MainController {

	private CategoryService categoryService;
	private ProductService productService;

	@Autowired
	public MainController(CategoryService categoryService, ProductService productService) {
		super();
		this.categoryService = categoryService;
		this.productService = productService;
	}

	@GetMapping
	public String main(Model model) {
		model.addAttribute("categories", categoryService.getAll());
		model.addAttribute("numberOfAll", productService.countSales());
		model.addAttribute("products", productService.getSales(0));
		return "mainpage";
	}

}
