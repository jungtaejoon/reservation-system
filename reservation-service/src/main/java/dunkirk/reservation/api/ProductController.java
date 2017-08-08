package dunkirk.reservation.api;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import dunkirk.reservation.domain.*;
import dunkirk.reservation.service.*;
import dunkirk.reservation.service.impl.ProductServiceImpl;

@RestController
public class ProductController {

	private ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}

	@GetMapping("/categories/{categoryId:[\\d]+}/products")
	public List<Product> getList(@PathVariable int categoryId, @RequestParam int start) {
		return new ProductServiceImpl(new ProductDao()).getList(categoryId, start);
	}
}
