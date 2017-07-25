package kr.or.connect.reservation.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.connect.reservation.config.NaverApiConfig;
import kr.or.connect.reservation.domain.Users;

@Controller
@RequestMapping("/")
public class MainController {
	
	@Autowired
	private NaverApiConfig naverConfig;
	
	@GetMapping
	public String index() {
		return "mainpage";
	}

	@GetMapping("/my")
	public String myreservation(Model model, HttpServletRequest request) {

		// 로그인에 성공하게 되면, userId 정보를 넣어서 model로 보냄
		Users user = (Users) request.getSession().getAttribute("loginedUser");
		request.getSession().setAttribute("prevPage", "my");

		if (user != null) {
//			model.addAttribute("loginedUser", user);
			return "myreservation";
		}

		return "redirect:/login";
	}

	@GetMapping("/products/{id}")
	public String detailProduct(Model model, @PathVariable("id") Long id) {
		model.addAttribute(id);
		return "detail";
	}
	
	@GetMapping("/products/{id}/reserve")
	public String reserveProduct(Model model, @PathVariable("id") Long id) {
		return "reserve";
	}

	@GetMapping("/review")
	public String review() {
		return "review";
	}
	
	
	@GetMapping("/login")
	public String login(HttpServletRequest request) {
		String accessToken = (String) request.getSession().getAttribute("token");
		String state = naverConfig.generateState(); // 토큰을 생성합니다.
		request.getSession().setAttribute("state", state); // 세션에 토큰을 저장합니다.
		
		// accessToken을 검증하여 로그인화면을 띄울 것인지 로그인 요청을 할 것인지에 대한 분개
		if(accessToken != null) {
			return "redirect:" + naverConfig.getOauthCallbackURL(state);
		} else {
			return "redirect:" + naverConfig.reAuthenticateUrl(state);
		}
		
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) throws UnsupportedEncodingException {
		
		request.getSession().removeAttribute("loginedUser");
		request.getSession().removeAttribute("token");
		
		return "redirect:/";
	}
}