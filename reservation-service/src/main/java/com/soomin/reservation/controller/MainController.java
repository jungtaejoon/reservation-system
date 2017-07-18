package com.soomin.reservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.soomin.reservation.domain.Category;
import com.soomin.reservation.domain.Product;
import com.soomin.reservation.service.CategoryService;
import com.soomin.reservation.service.ProductService;

@Controller
@RequestMapping("/")
public class MainController {
	@Autowired
	ProductService productService;
	@Autowired
	CategoryService categoryService;
	
	@GetMapping("category")
	public String category(Model model) {
		List<Category> categories = categoryService.viewCategory();
		model.addAttribute("categoryList", categories);
		
		return "category";
	}
	
	@GetMapping
	public String product(Model model) {
		List<Product> promotions = productService.viewPromotion();
		List<Category> categories = categoryService.viewCategory();
		Long numberOfProduct = productService.numberOfProduct((long) 0);
		
		model.addAttribute("promotionList", promotions);
		model.addAttribute("categoryList", categories);
		model.addAttribute("numberOfProduct", numberOfProduct);
		
		return "mainpage";
	}
	
	
	@GetMapping("/my")
	public String myreservation(Model model) {
		return "myreservation";
	}
	
	@PostMapping("/category/add")
	public String add(@RequestParam(name="name") String name) {
		Category category = new Category(name);
		Category result = categoryService.addCategory(category);
		
		return "redirect:/category";
	}
}
