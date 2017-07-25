package won.reservation.controller;

import java.sql.Timestamp;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import won.reservation.domain.ReservationInfo;
import won.reservation.service.ProductPriceService;
import won.reservation.service.ProductService;
import won.reservation.service.ReservationInfoService;
import won.reservation.service.UsersService;

@Controller
@RequestMapping("/reserve")
public class ReserveController {
	
	private ProductService productService;
	private ProductPriceService productPriceService;
	private UsersService usersService;
	private ReservationInfoService reservationInfoService;
	
	@Autowired
	public ReserveController(ProductService productService, ProductPriceService productPriceService, 
			UsersService usersService, ReservationInfoService reservationInfoService) {
		this.productService = productService;
		this.productPriceService = productPriceService;
		this.usersService = usersService;
		this.reservationInfoService = reservationInfoService;
	}
	
	@GetMapping
	@RequestMapping("/{productId}")
	public String main(@PathVariable("productId") Integer productId, Model model, HttpSession session) {
		Integer userId;
		model.addAttribute("product", productService.getProduct(productId));
		model.addAttribute("ticketPrice", productPriceService.get(productId));
		if((userId = (Integer) session.getAttribute("userId")) != null) {		
			model.addAttribute("user", usersService.get(userId));
		}
		return "reserve";
	}
	
	@PostMapping
	@ResponseBody
	public String add(HttpSession session, @ModelAttribute ReservationInfo reservationInfo) {
		Integer userId = (Integer) session.getAttribute("userId");
		reservationInfo.setUserId(userId);
		reservationInfo.setCreateDate(new Timestamp(System.currentTimeMillis()));
		reservationInfo.setModifyDate(new Timestamp(System.currentTimeMillis()));
		reservationInfo.setReservationDate(new Timestamp(System.currentTimeMillis()));
		reservationInfoService.add(reservationInfo);
		return "success";
	}
}
