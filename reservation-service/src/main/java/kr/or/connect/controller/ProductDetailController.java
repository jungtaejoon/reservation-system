package kr.or.connect.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import kr.or.connect.service.*;

@Controller
@RequestMapping("/product-detail")
public class ProductDetailController {

	private ProductService productService;
	private CommentService commentService;

	@Autowired
	public ProductDetailController(ProductService productService, CommentService commentService) {
		super();
		this.productService = productService;
		this.commentService = commentService;
	}

	@GetMapping("/{id:[\\d]+}")
	public String productDetail(@PathVariable Long id, Model model) {
		model.addAttribute("productDetail", productService.getDetail(id));
		model.addAttribute("comments", commentService.selectByProduct(id, 0, 3));
		model.addAttribute("images", productService.getImages(id));
		return "detail";
	}

}
