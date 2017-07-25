package kr.or.connect.reservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.reservation.dto.ProductDTO;
import kr.or.connect.reservation.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductRestController {
	
	@Autowired
	private ProductService service;
	
	@GetMapping
	public List<ProductDTO> selectProducts() {
		List<ProductDTO> list = service.selectProductsAll();
		
		return list;
	}
	
	@GetMapping("/{categoryId}/categories")
	public List<ProductDTO> selectProductByCategoryId(@PathVariable int categoryId) {
		List<ProductDTO> list = service.selectProductByCategoryId(categoryId);
		
		return list;
	}
	
	@GetMapping("/{id}")
	public ProductDTO selectProductById(@PathVariable int id) {
		return service.selectProductById(id);
	}
	
	@GetMapping("/{id}/imageCount")
	public List<ProductDTO> selectProductImageIdByProductId(@PathVariable int id) {
		return service.selectProductImageIdByProductId(id);
	}
	
	
	
	

}
