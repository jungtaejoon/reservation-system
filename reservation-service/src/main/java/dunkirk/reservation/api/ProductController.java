package dunkirk.reservation.api;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import dunkirk.reservation.service.*;
import durkirk.reservation.dto.*;

@RestController
public class ProductController {

	private ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}

	@GetMapping("/categories/{categoryId:[\\d]+}/products")
	public List<ProductForMainDto> getList(@PathVariable int categoryId, @RequestParam int page) {
		return productService.getList(categoryId, page*10);
	}
}
