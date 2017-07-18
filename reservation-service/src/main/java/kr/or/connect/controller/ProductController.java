package kr.or.connect.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import kr.or.connect.dto.*;
import kr.or.connect.service.*;

@RestController
@RequestMapping("/products")
public class ProductController {

	private ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}
	
	@GetMapping("/firstindex/{firstIndex:[\\d]+}")
	public List<ProductDisplayDto> getSales(@PathVariable Integer firstIndex) {
		return productService.getSales(firstIndex);
	}
	
	@GetMapping("/counts")
	public int countSales() {
		return productService.countSales();
	}
	
	@GetMapping("/categories/{categoryId:[\\d]+}/firstindex/{firstIndex:[\\d]+}")
	public List<ProductDisplayDto> getSalesByCategory(@PathVariable Long categoryId, @PathVariable Integer firstIndex) {
		return productService.getSalesByCategory(categoryId, firstIndex);
	}
	
	@GetMapping("/categories/{categoryId:[\\d]+}/counts")
	public int countSalesByCategory(@PathVariable Long categoryId) {
		return productService.countSalesByCategory(categoryId);
	}
	
}
