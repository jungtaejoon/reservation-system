package com.soomin.reservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.soomin.reservation.domain.Category;
import com.soomin.reservation.domain.Product;
import com.soomin.reservation.dto.ProductInfo;
import com.soomin.reservation.service.CategoryService;
import com.soomin.reservation.service.ProductInfoService;
import com.soomin.reservation.service.ProductService;

@Controller
@RequestMapping("/")
public class MainController {
	@Autowired
	ProductService productService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	ProductInfoService productInfoService;
	
	@GetMapping
	public String product(Model model) {
		List<Product> promotions = productService.getPromotion();
		List<Category> categories = categoryService.viewCategory();
		Long countProducts = productService.countProduct((long) 0);
		
		model.addAttribute("promotionList", promotions);
		model.addAttribute("categoryList", categories);
		model.addAttribute("countProducts", countProducts);
		
		return "mainpage";
	}
	
	@GetMapping("/category")
	public String category(Model model) {
		List<Category> categories = categoryService.viewCategory();
		model.addAttribute("categoryList", categories);
		
		return "category";
	}
	
	@GetMapping("/my")
	public String myreservation(Model model) {
		return "myreservation";
	}
	
	@GetMapping("/detail/{id}")
	public String detail(Model model, @PathVariable Long id) {
		ProductInfo productInfo = productInfoService.getProductInfo(id);
		model.addAttribute("product_info", productInfo);
		
		return "detail";
	}
	
}
