package won.reservation.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value= {"/myreservation"})
public class MyReservationController {
	
	@GetMapping
	public String main(HttpSession session) {
		if(!"success".equals(session.getAttribute("loginStatus"))) {
			return "redirect:/api/users";
		}
		
		return "myreservation";
	}
}
