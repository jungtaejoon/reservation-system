package dunkirk.reservation.api;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dunkirk.reservation.domain.ReservationInfo;
import dunkirk.reservation.service.ReservationService;

@RestController
@RequestMapping("/reurl")	// 수정하기
public class ReservationRestController {

	private ReservationService reservationService;
	
	public ReservationRestController(ReservationService reservationService) {
		this.reservationService = reservationService;
	}
	
	@PutMapping
	public int add() {
		ReservationInfo reservationInfo = null;
		return reservationService.add(reservationInfo);
	}
}
