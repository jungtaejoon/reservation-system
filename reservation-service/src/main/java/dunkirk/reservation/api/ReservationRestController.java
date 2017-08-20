package dunkirk.reservation.api;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dunkirk.reservation.domain.ReservationInfo;
import dunkirk.reservation.service.ReservationService;

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

    @DeleteMapping("/{id}")
    public int delete(@PathVariable int id) {
        return reservationService.remove(id);
    }
}
