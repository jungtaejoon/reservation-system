package won.reservation.api;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import won.reservation.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	static final int DISPLAY_NUM = 3;
	
	private ProductService service;
	
	@Autowired
	public ProductController(ProductService service) {
		this.service = service;
	}	
	
	@GetMapping("/info/{start}")
	public Map<String, Object> list(@PathVariable int start) {
		return service.getProductInfo(start*DISPLAY_NUM);
	}

	@GetMapping("/info/{categoryId}/start/{start}")
	public Map<String, Object> listCategory(@PathVariable(name = "categoryId") int categoryId, @PathVariable(name = "start") int start) {
		return service.getProductInfoCategory(categoryId, start*DISPLAY_NUM);
	}
}
