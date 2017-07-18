package kgw.reservation.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {
	private static final String DIRNAME ="/user";
	public UserController() {
	}
	
	@RequestMapping("/{id}")
	public String myPage(@PathVariable String id) {
		return DIRNAME+"/myreservation";
	}
}
