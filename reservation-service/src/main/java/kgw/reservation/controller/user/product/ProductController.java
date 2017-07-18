package kgw.reservation.controller.user.product;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kgw.reservation.dto.ProductInfo;
import kgw.reservation.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {
	private ProductService productService;
	private static final String DIRNAME ="/user";
	
	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping("/{id}")
	public String detailPage(@PathVariable Integer id, Model model) {
		model.addAttribute("products", productService.findById(id));
		
		return DIRNAME+"/detail";
	}
	
	@GetMapping
	@ResponseBody
	public Collection<ProductInfo> readList(@RequestParam(required=false) Integer categoryId, @RequestParam(required=false) Integer offset, @RequestParam(required=false) Integer size) {
		if(offset == null || size == null ) {
			offset = 0;
			size = 10;
		}
		if(categoryId != null)
			return productService.findByCategoryLimit(categoryId, offset, size);
		
		return productService.findAllLimit(offset, size);
	}

	@GetMapping("/counts")
	@ResponseBody
	public Integer countList(@RequestParam(required=false) Integer categoryId) {
		if(categoryId != null)
			return productService.countByCategory(categoryId);
		return productService.countAll();
	}
	
}
