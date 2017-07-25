package kr.or.connect.jy.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/myreservation")
public class MyReservationController {
	@GetMapping
	String main(HttpServletRequest request, HttpSession session) {
		return "myreservation";
	}
	
}
