package dunkirk.reservation.controller;

import dunkirk.reservation.config.AuthUser;
import dunkirk.reservation.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import dunkirk.reservation.service.ReservationService;

@Controller
public class MyReservationController {
    private ReservationService reservationService;

    @Autowired
    public MyReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/my-reservation")
    public String mypage(Model model, @AuthUser User user) {
        int userId = user.getId();
        model.addAttribute("myCount", reservationService.getReservationTypeCountList(userId));
        model.addAttribute("myReservations", reservationService.getList(userId));
        return "myreservation";
    }
}
