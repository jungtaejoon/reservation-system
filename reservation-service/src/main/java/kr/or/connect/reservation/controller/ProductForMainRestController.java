package kr.or.connect.reservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.reservation.domain.ProductForMain;
import kr.or.connect.reservation.service.ProductForMainService;

@RestController
@RequestMapping("/api/product-for-main")
public class ProductForMainRestController {
	ProductForMainService service;
	
	@Autowired
	public ProductForMainRestController (ProductForMainService service) {
		this.service = service;
	}
	
	@GetMapping
	public List<ProductForMain> getAll(@RequestParam Integer start, @RequestParam Integer count) {
		return service.getAll(start, count);
	}
	
	@GetMapping("/{categoryId}")
	public List<ProductForMain> getByCategory(@PathVariable Integer categoryId, @RequestParam Integer start, @RequestParam Integer count) {
		return service.getByCategory(categoryId, start, count);
	}
	
	@GetMapping("/count")
	public Integer countAll() {
		return service.countAll();
	}
	
	@GetMapping("/count/{categoryId}")
	public Integer countByCategory(@PathVariable Integer categoryId) {
		return service.countByCategory(categoryId);
	}
	
	@GetMapping("/visual")
	public List<ProductForMain> getVisual() {
		return service.getVisual();
	}

}
