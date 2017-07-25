package kr.or.connect.api;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.*;

import kr.or.connect.domain.*;
import kr.or.connect.dto.*;
import kr.or.connect.service.*;

@RestController
@RequestMapping("/products")
public class ProductController {

	private ProductService productService;
	private CommentService commentService;
	private FileService fileService;

	@Autowired
	public ProductController(ProductService productService, CommentService commentService, FileService fileService) {
		super();
		this.productService = productService;
		this.commentService = commentService;
		this.fileService = fileService;
	}

	@GetMapping
	public List<ProductDisplayDto> getSales(@RequestParam(value="start") Integer start) {
		return productService.getSales(start);
	}

	@GetMapping("/count")
	public int countSales() {
		return productService.countSales();
	}

	@GetMapping("/{productId:[\\d]+}/comments")
	public List<CommentDto> getSomeComments(@PathVariable Long productId, @RequestParam(value="start") Integer start, @RequestParam(value="amount") Integer amount) {
		return commentService.selectByProduct(productId, start, amount);
	}

	@PostMapping("/{productId:[\\d]+}/images")
	public List<ProductImage> insertImages(@PathVariable Long productId,
			@RequestParam("mainImage") MultipartFile mainImage, @RequestParam("subImages") MultipartFile[] subImages) {
		return fileService.insertImages(productId, mainImage, subImages);
	}

}
