package connect.reservation.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import connect.reservation.service.ProductInfoService;

@RestController
@RequestMapping("/productInfo")
public class ProductInfoController {
	private final ProductInfoService productInfoService;

final static int productNum = 10;
	
	@Autowired
	public ProductInfoController(ProductInfoService productInfoService) {
		this.productInfoService = productInfoService;
	}
	
	
	@GetMapping("/all/{start}")
	public Map<String, Object> getAllProduct(@PathVariable int start) {

		return productInfoService.getMainInfo(start*productNum);
	}
	
	@GetMapping("/category/{categoryId}/start/{start}")
	public Map<String, Object> getCategoryProduct(@PathVariable(name = "categoryId") int categoryId, @PathVariable(name = "start") int start) {
		return productInfoService.getCategoryInfo(categoryId, start*productNum);
	}
}
