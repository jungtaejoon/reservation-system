package kr.or.connect.jy.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.jy.dto.ProductDTO;
import kr.or.connect.jy.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductAPIController {
	private ProductService productService;

	@Autowired
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

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

	@GetMapping("/{categoryId}/more/{lastProductId}")
	public Collection<ProductDTO> selectByCategoryIdFromLast(@PathVariable Integer categoryId,
			@PathVariable Integer lastProductId) {
		return productService.selectByCategoryIdFromLast(categoryId, lastProductId);
	}

	@GetMapping("/count")
	public Integer countAll() {
		return productService.countAll();
	}

	@GetMapping("/{categoryId}/count")
	public Integer countByCategoryId(@PathVariable Integer categoryId) {
		return productService.countByCategoryId(categoryId);
	}
}
