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
@RequestMapping("/api/product")
public class ProductRestController {
	@Autowired
	private ProductService productService;
	
	@GetMapping("/number/{categoryId}")
	public Long numberOfProduct(@PathVariable Long categoryId){
		return productService.numberOfProduct(categoryId);
	}
	@GetMapping("/list/{categoryId}/{offset}")
	public List<Product> productList(@PathVariable("categoryId") Long categoryId, @PathVariable("offset") Long offset){
		return productService.viewProduct(categoryId, offset);
	}
}
