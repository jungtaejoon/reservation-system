package kr.or.connect.jy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.jy.dto.ProductDTOForReserve;
import kr.or.connect.jy.service.ReservingService;

@RestController
@RequestMapping("/api/reserving")
public class ReserveAPIController {

	private ReservingService reservingService;
	
	@Autowired
	public ReserveAPIController(ReservingService reservingService) {
		super();
		this.reservingService = reservingService;
	}

	@GetMapping("/products/{categoryId}/product/{productId}")
	public ProductDTOForReserve home (@PathVariable Integer productId) {
		return reservingService.selectDTOForReserveByProductId(productId);
	}
}
