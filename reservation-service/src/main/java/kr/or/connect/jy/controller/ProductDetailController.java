package kr.or.connect.jy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.connect.jy.service.ProductService;

@Controller
@RequestMapping("/products/{categoryId}/product")
public class ProductDetailController {
	private ProductService productService;

	@Autowired
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping("/{id}/review")
	public String viewMoreReview(@PathVariable int id) {
		return "review";
	}

	@GetMapping("/{id}/map")
	public String goMap(@PathVariable int id, @RequestParam("address") String address, Model model) {
		model.addAttribute("address", address);
		return "navermap";
	}

	@GetMapping("/{id}")
	public String viewDetail(@PathVariable int id, Model model) {
		model.addAttribute("product", productService.selectDTOByProductId(id));
		return "detail";
	}
}
