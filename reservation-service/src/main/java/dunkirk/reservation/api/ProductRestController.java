package dunkirk.reservation.api;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import dunkirk.reservation.dto.*;
import dunkirk.reservation.service.*;

@RestController
@RequestMapping("/products")
public class ProductRestController {

	private ProductService productService;

	@Autowired
	public ProductRestController(ProductService productService) {
		super();
		this.productService = productService;
	}

	@GetMapping
	public List<ProductForMainDto> getList(@RequestParam int categoryId, @RequestParam int page) {
		return productService.getList(categoryId, page*10);
	}
}
