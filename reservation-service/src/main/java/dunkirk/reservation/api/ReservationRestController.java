package dunkirk.reservation.api;

import dunkirk.reservation.domain.ReservationInfo;
import dunkirk.reservation.service.ReservationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservations")    // 수정하기
public class ReservationRestController {

    private ReservationService reservationService;

    public ReservationRestController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping
    public int add(@RequestBody ReservationInfo reservationInfo) {
        if (reservationInfo != null) {
            reservationInfo.setUserId(1);
            return reservationService.add(reservationInfo);
        } else {
            return -1;
        }
    }
}
