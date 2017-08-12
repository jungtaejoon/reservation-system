package dunkirk.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import dunkirk.reservation.service.*;

@Controller
public class ViewController {

	private ProductService productService;

	@Autowired
	public ViewController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping("/")
	public String home(Model model) {
		return "mainpage";
	}

	@GetMapping("/product-detail/{productId:[\\d]+}")
	public String detail(Model model, @PathVariable int productId) {
		model.addAttribute("product", productService.getDetail(productId));
		return "detail";
	}
}
