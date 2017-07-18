package kr.or.connect.controller;

import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("product-detail")
public class ProductDetailController {
	
	@GetMapping
	public String productDetail(Model model) {
		return "detail";
	}

}
