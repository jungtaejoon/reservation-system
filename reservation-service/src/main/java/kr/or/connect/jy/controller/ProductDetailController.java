package kr.or.connect.jy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.connect.jy.service.ProductDetailService;

@Controller
@RequestMapping("/product/detail")
public class ProductDetailController {
	@Autowired
	private ProductDetailService productDetailService;

	@GetMapping("/{id}")
	public String viewDetail(@PathVariable int id, Model model) {
		model.addAttribute("product", "product");
		return "detail";
	}
}
