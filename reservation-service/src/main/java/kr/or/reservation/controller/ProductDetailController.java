package kr.or.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.or.reservation.service.CommentForDetailService;
import kr.or.reservation.service.ImgService;
import kr.or.reservation.service.ProductForDetailService;

@Controller
@RequestMapping(path = "/product")
public class ProductDetailController {

	ProductForDetailService detailService;
	ImgService imgService;
	CommentForDetailService commentForDetailService;
	
	@Autowired
	public ProductDetailController(ProductForDetailService detailService, 
			ImgService imgService,CommentForDetailService commentForDetailService) {
		this.detailService = detailService;
		this.imgService = imgService;
		this.commentForDetailService =commentForDetailService;
	}

	@GetMapping
	@RequestMapping("/detail/{id}")
	public String getProductDetail(Model model, @PathVariable(name = "id") int id) {
		model.addAttribute("detail", detailService.selectOne(id));
		model.addAttribute("img",imgService.selectList(id));
		model.addAttribute("comment",commentForDetailService.selectByProductId(id));
		model.addAttribute("avg",commentForDetailService.selectAvgScoreByProductId(id));
		return "detail";
	}

}