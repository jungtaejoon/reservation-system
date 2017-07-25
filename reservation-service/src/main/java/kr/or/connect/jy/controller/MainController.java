package kr.or.connect.jy.controller;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.security.SecureRandom;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.connect.jy.service.CategoryService;

@Controller
@RequestMapping("/")
public class MainController {
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping
	public String main(HttpSession session, Model model) {
	    String clientId = "8MZOYydXJnYsvoXzMzaU";//애플리케이션 클라이언트 아이디값";
	    String redirectURI = null;
	    
		try {
			redirectURI = URLEncoder.encode("http://127.0.0.1:8080/naver_callback", "UTF-8");
		    SecureRandom random = new SecureRandom();
		    String state = new BigInteger(130, random).toString();
		    String apiURL = "https://nid.naver.com/oauth2.0/authorize?response_type=code";
		    apiURL += "&client_id=" + clientId;
		    apiURL += "&redirect_uri=" + redirectURI;
		    apiURL += "&state=" + state;
		    
		    session.setAttribute("state", state);
			model.addAttribute("apiURL", apiURL);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		model.addAttribute("categories", categoryService.selectAll());
		
		return "mainpage";
	}
}
