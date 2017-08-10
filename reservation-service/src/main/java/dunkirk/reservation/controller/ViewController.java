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
	private CommentService commentService;
	private FileService fileService;
	
	@Autowired
	public ViewController(
			ProductService productService,
			CommentService commentService,
			FileService fileService) {
		this.productService = productService;
		this.commentService = commentService;
		this.fileService = fileService;
	}
	
	@GetMapping("/")
	public String home(Model model) {
		return "mainpage";
	}
	
	@GetMapping("/product-detail/{productId:[\\d]+}")
	public String detail(Model model, @PathVariable int productId) {
		model.addAttribute("product", productService.getDetail(productId));
		model.addAttribute("productImages", fileService.getProductImageList(productId));
		model.addAttribute("comments", commentService.getListByProduct(0, 3, productId));
		model.addAttribute("noticeImages", fileService.getProductNoticeImageList(productId));
		model.addAttribute("informationImage", fileService.getProductInformationImage(productId));
		return "detail";
	}
}
