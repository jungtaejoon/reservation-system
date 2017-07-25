package com.juhyung.reservation.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.juhyung.reservation.domain.PageCriteria;
import com.juhyung.reservation.domain.Price;
import com.juhyung.reservation.domain.ProductVO;
import com.juhyung.reservation.domain.Reservation;
import com.juhyung.reservation.dto.DetailProduct;
import com.juhyung.reservation.dto.ProductDTO;
import com.juhyung.reservation.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	private ProductService productService;
	
	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping
	public List<ProductDTO> getProductListAll(@RequestParam int page) throws Exception {
		return productService.getListPage(new PageCriteria(page));
	}
	
	@GetMapping("/count")
	public Integer getCountProductAll() throws Exception {
		return productService.getCountSaleProduct();
	}
	
	@GetMapping("/{id}")
	public DetailProduct read(@PathVariable int id) throws Exception {
		return productService.getDetailProductById(id);
	}
	
	@GetMapping("/{id}/images")
	public List<Integer> getImagesByProduct(@PathVariable Integer id) throws Exception {
		return productService.getImagesByProduct(id);
	}
	
	// promotion관련 api (아직 사용 하지 않음)
	@GetMapping("/promotion")
	public List<ProductVO> listPromotion() throws Exception {
		return productService.getListPromotion();
	}
	
	@GetMapping("/{id}/price")
	public List<Price> getPriceByProduct(@PathVariable int id){
		return productService.getPriceByProduct(id);
	}
	
	@GetMapping("/{id}/image")
	public int getMainImageOfProduct(@PathVariable int id){
		return productService.getMainImageOfProduct(id);
	}
	
	@PostMapping("/{id}/reservation")
	public void serReservation(HttpSession session, @PathVariable int id, @RequestBody Reservation reservation){
		reservation.setProductId(id);
		reservation.setUserId((int)session.getAttribute("login"));
		reservation.setReservationDate(new Date(System.currentTimeMillis()));
		productService.setReservation(reservation);
	}
}
