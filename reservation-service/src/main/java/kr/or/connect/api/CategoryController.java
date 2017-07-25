package kr.or.connect.api;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import kr.or.connect.domain.*;
import kr.or.connect.dto.*;
import kr.or.connect.service.*;

@RestController
@RequestMapping("/categories")
public class CategoryController {

	CategoryService categoryService;
	ProductService productService;

	@Autowired
	public CategoryController(CategoryService categoryService, ProductService productService) {
		super();
		this.categoryService = categoryService;
		this.productService = productService;
	}

	@GetMapping
	public List<Category> getAll() {
		return categoryService.getAll();
	}

	@PostMapping
	public Category insert(@RequestBody Category category) {
		return categoryService.insert(category);
	}

	@DeleteMapping("/{id:[\\d]+}")
	public int delete(@PathVariable Long id) {
		return categoryService.delete(id);
	}

	@GetMapping("/{categoryId:[\\d]+}/products")
	public List<ProductDisplayDto> getSalesByCategory(@PathVariable Long categoryId, @RequestParam(value="start") Integer start) {
		return productService.getSalesByCategory(categoryId, start);
	}

	@GetMapping("/{categoryId:[\\d]+}/products/count")
	public int countSalesByCategory(@PathVariable Long categoryId) {
		return productService.countSalesByCategory(categoryId);
	}

}
