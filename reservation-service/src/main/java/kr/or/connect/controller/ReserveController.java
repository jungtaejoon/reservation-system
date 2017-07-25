package kr.or.connect.controller;

import java.io.*;
import java.net.*;

import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import kr.or.connect.service.*;
import kr.or.connect.util.*;

@Controller
@RequestMapping("/reserve")
public class ReserveController {

	private static final String CLIENT_ID = "UT0zsTGjviSL7f6l7c1Q";
	private static final String NAVER_OAUTH_AUTHORIZE_URL = "https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id="
			+ CLIENT_ID + "&redirect_uri=";
	private static final String TARGET_JSP = "reserve";

	private String redirectUri;
	private UserService userService;
	private GetStateUtil getStateUtil;
	private ProductService productService;
	
	@Autowired
	public ReserveController(UserService userService, GetStateUtil getStateUtil, ProductService productService) {
		super();
		this.userService = userService;
		this.getStateUtil = getStateUtil;
		this.productService = productService;
	}

	@GetMapping("/{productId:[\\d]+}")
	public String reserve(@PathVariable Long productId, HttpSession session, Model model, HttpServletRequest request) {
		if (session.getAttribute("email") != null) {
			if(userService.selectByEmail((String)session.getAttribute("email")) != null) {
				model.addAttribute("user", userService.selectByEmail((String)session.getAttribute("email")));
				model.addAttribute("prices", productService.getPrice(productId));
				model.addAttribute("productDetail", productService.getDetail(productId));
				model.addAttribute("images", productService.getImages(productId));
				return TARGET_JSP;
			} 
		} 
		String state = getStateUtil.getState();
		session.setAttribute("state", state);
		String targetURI = request.getRequestURI();
		try {
			this.redirectUri = URLEncoder.encode("http://localhost:8080/login" + targetURI, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "redirect:" + NAVER_OAUTH_AUTHORIZE_URL + this.redirectUri + "&state=" + state;
	}
}
