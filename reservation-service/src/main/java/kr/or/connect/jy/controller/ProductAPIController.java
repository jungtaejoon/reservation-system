package kr.or.connect.jy.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.jy.dto.Product;
import kr.or.connect.jy.dto.ProductDTO;
import kr.or.connect.jy.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductAPIController {
	@Autowired
	private ProductService productService;
	
	@GetMapping
	public Collection<ProductDTO> selectAll() {
		return productService.selectAll();
	}
	
	@GetMapping("/{categoryId}")
	public Collection<ProductDTO> selectByCategoryId(@PathVariable Integer categoryId) {
		return productService.selectByCategoryId(categoryId);
	}
	
	@GetMapping("/more/{lastProductId}")
	public Collection<ProductDTO> selectFromLast(@PathVariable Integer lastProductId) {
		return productService.selectFromLast(lastProductId);
	}
	
	@GetMapping("/more/{categoryId}/{lastProductId}")
	public Collection<ProductDTO> selectByCategoryIdFromLast(@PathVariable Integer categoryId, @PathVariable Integer lastProductId) {
		return productService.selectByCategoryIdFromLast(categoryId, lastProductId);
	}
	
	@GetMapping("/count")
	public Integer countAll() {
		return productService.countAll();
	}
	
	@GetMapping("/count/{categoryId}")
	public Integer countByCategoryId(@PathVariable Integer categoryId) {
		return productService.countByCategoryId(categoryId);
	}

}
