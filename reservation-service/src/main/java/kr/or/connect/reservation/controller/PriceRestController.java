package kr.or.connect.reservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.reservation.domain.Price;
import kr.or.connect.reservation.service.PriceService;

@RestController
@RequestMapping("/api/price")
public class PriceRestController {
	
	PriceService service;
	
	@Autowired
	public PriceRestController(PriceService service) {
		this.service = service;
	}
	
	@GetMapping("/{productId}")
	public List<Price> getByProductId(@PathVariable Integer productId) {
		return service.getByProductId(productId);
	}
}
