package kr.or.connect.controller;

import javax.servlet.http.*;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/login")
public class LoginController {

	@GetMapping
	public void login(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		System.out.println();
	}
}
