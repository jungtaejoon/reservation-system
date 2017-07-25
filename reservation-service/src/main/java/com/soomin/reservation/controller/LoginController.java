package com.soomin.reservation.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.soomin.reservation.bo.NaverLoginBo;
import com.soomin.reservation.dto.NaverLoginUser;
import com.soomin.reservation.dto.NaverLoginUserResult;
import com.soomin.reservation.service.UsersService;

@Controller
public class LoginController {
	@Autowired
	NaverLoginBo naverLoginBo;
	@Autowired
	UsersService usersService;
	
	@RequestMapping("/login")
	public String login(HttpSession session) {
		//네이버 로그인 요청 url 생성
		String naverAuthUrl = naverLoginBo.getAuthorizationUrl(session);
		
		//세션에 저장
		session.setAttribute("url", naverAuthUrl);
		
		//로그인 페이지 생성
		return "login";
	}
	
	//콜백 url 실행 시
	@RequestMapping("/naver_callback")
	public String callback(@RequestParam String code, @RequestParam String state, HttpSession session) throws IOException {
		//code, state는 엑세스토큰 발급 시 사용
		System.out.println(state+" / "+code);
		//엑세스 토큰
		OAuth2AccessToken oauthToken = naverLoginBo.getAccessToken(session, code, state);
		
		//사용자 정보 리턴, json string
		String apiResult = naverLoginBo.getUserProfile(oauthToken);
		//json string -> object
		ObjectMapper objectMapper = new ObjectMapper();
		NaverLoginUser result = objectMapper.readValue(apiResult, NaverLoginUserResult.class).getResponse();
		System.out.println(usersService.addNaverUser(result));
		
		//로그인화면 리다이렉트
		return "myreservation";
	}
}
