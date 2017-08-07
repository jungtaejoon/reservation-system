package dunkirk.reservation.controller;

import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class ViewController {

	@GetMapping("/")
	public String home(Model model) {
		return "mainpage";
	}
}
