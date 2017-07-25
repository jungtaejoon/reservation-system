package kr.or.connect.jy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.connect.jy.service.ReservingService;

@Controller
@RequestMapping("/reserving")
public class ReserveController {
	
	private ReservingService reservingService;
	
	@Autowired
	public ReserveController(ReservingService reservingService) {
		super();
		this.reservingService = reservingService;
	}

	@GetMapping("/products/{categoryId}/product/{productId}")
	public String home (@PathVariable Integer productId, Model model) {
		model.addAttribute(reservingService.selectDTOForReserveByProductId(productId));
		return "reserve";
	}
}
