package com.juhyung.reservation.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juhyung.reservation.domain.User;
import com.juhyung.reservation.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping
	public User getUserById(HttpSession session){
		return userService.getUserById((int)session.getAttribute("login"));
	}
}
