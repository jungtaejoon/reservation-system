package kr.or.connect.jy.controller;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.jy.dto.CommentImageDTO;
import kr.or.connect.jy.dto.ProductDTO;
import kr.or.connect.jy.dto.ProductImageDTO;
import kr.or.connect.jy.service.CommentService;
import kr.or.connect.jy.service.ProductDetailService;
import kr.or.connect.jy.service.ProductService;

@RestController
@RequestMapping("/api/products/{categoryId}/product")
public class ProductDetailAPIController {
	private ProductDetailService productDetailService;
	private CommentService commentService;
	private ProductService productService;

	@Autowired
	public void setProductDetailService(ProductDetailService productDetailService) {
		this.productDetailService = productDetailService;
	}

	@Autowired
	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}

	@Autowired
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping("/{productId}/images")
	public Collection<ProductImageDTO> selectById(@PathVariable Integer productId) {
		return productDetailService.selectByProductIdForDetail(productId);
	}

	@GetMapping("/{productId}/comments")
	public Map<String, Object> getUserCommentInfoMap(@PathVariable int productId) {
		return commentService.getUserCommentInfoMap(productId);
	}
	
	@GetMapping("/{productId}/comments/{commentId}/images")
	public List<CommentImageDTO> getCommentImages(@PathVariable int commentId) {
		return commentService.getCommentImages(commentId);
	}

	@GetMapping("/{productId}")
	public ProductDTO selectDTOByProductId(@PathVariable int productId) {
		return productService.selectDTOByProductId(productId);
	}

}
