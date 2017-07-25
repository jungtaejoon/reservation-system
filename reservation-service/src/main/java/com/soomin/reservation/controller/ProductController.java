package com.soomin.reservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soomin.reservation.domain.Product;
import com.soomin.reservation.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@GetMapping("/count/{categoryId}")
	public Long countProduct(@PathVariable Long categoryId){
		return productService.countProduct(categoryId);
	}
	@GetMapping("/categories/{categoryId}/pages/{offset}")
	public List<Product> productList(@PathVariable("categoryId") Long categoryId, @PathVariable("offset") Long offset){
		return productService.getProduct(categoryId, offset);
	}
}
