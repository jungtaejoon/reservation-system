package kr.or.connect.reservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.reservation.dto.ImageForDetail;
import kr.or.connect.reservation.dto.ProductForDetail;
import kr.or.connect.reservation.service.ProductForDetailService;

@RestController
@RequestMapping("/api/detail")
public class DetailRestController {
	ProductForDetailService service;
	
	@Autowired
	public DetailRestController(ProductForDetailService service) {
		this.service = service;
	}
	
	@GetMapping("/info/{id}")
	public ProductForDetail getInfo(@PathVariable Integer id) {
		return service.getInfo(id);
	}
	
	@GetMapping("/images/{id}")
	public List<ImageForDetail> getImages(@PathVariable Integer id) {
		return service.getImages(id);
	}
}
