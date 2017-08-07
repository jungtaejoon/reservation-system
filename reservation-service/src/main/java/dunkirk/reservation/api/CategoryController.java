package dunkirk.reservation.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import dunkirk.reservation.domain.Category;
import dunkirk.reservation.service.CategoryService;

@RestController
public class CategoryController {

	private CategoryService categoryService;
	
	@Autowired
	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	@GetMapping("/categories")
	public List<Category> getList() {
		return categoryService.getList();
	}
}
