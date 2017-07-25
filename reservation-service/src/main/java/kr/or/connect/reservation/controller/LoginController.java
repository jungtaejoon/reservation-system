package kr.or.connect.reservation.controller;

import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.connect.reservation.config.UrlParsingToJSON;
import kr.or.connect.reservation.domain.Users;
import kr.or.connect.reservation.service.LoginService;
import kr.or.connect.reservation.service.UserService;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	private final static String CLIENT_ID = "L2nqIoSATCDyk0dckfDi";
	private final static String CLIENT_SECRET = "Ze1rBxVW5l";
	private final static String REDIRECT_URI = "http://localhost:8080/login/Oauth";
	private final static String NAVER_LOGIN_AUTHORIZATION_REQUEST_URL = "https://nid.naver.com/oauth2.0/authorize?client_id="+CLIENT_ID+"&response_type=code&redirect_uri="+REDIRECT_URI+"&state=";
	private final static String ACCESS_TOKEN_REQUEST_URL = "https://nid.naver.com/oauth2.0/token?client_id="+CLIENT_ID+"&client_secret="+CLIENT_SECRET+"&grant_type=authorization_code";
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public String createStateToken(HttpSession session) {	
		SecureRandom random = new SecureRandom();
	    // 상태 토큰으로 사용할 랜덤 문자열 생성
	    String state = new BigInteger(130, random).toString(32);
	    // 세션 또는 별도의 저장 공간에 상태 토큰을 저장
	    session.setAttribute("state", state);
	    return "redirect:"+ NAVER_LOGIN_AUTHORIZATION_REQUEST_URL + state;
	}
	
	@GetMapping("/Oauth")
	public String login(HttpServletRequest request, HttpSession session, @ModelAttribute Users newUsers) throws IOException {
		// 콜백 응답에서 state 파라미터의 값을 가져옴
		String state = request.getParameter("state");
		String code = request.getParameter("code");

		// 세션에서 상태 토큰을 가져옴
		String storedState = (String) session.getAttribute("state");
		session.removeAttribute("state");
		
		if( !state.equals( storedState ) || storedState == null ) {//상태토큰이 만들어 지지 않았을 경우(정상적인 로그인 경로를 벗어난경우)
		    return "/";
		} 
				
		String accessTokenRequestURL = ACCESS_TOKEN_REQUEST_URL 
									+"&state=" + state 
									+"&code=" + code;
	    
		//JSON 객체 생성
		JSONObject accessTokenJson = UrlParsingToJSON.readJsonFromUrl(accessTokenRequestURL);
	
		String access_token = accessTokenJson.get("access_token")+"";
	    String header = "Bearer " + access_token;
	    
	    HashMap<String,String> userInfo = loginService.selectUserProfile(header);
	    
	    Users users = userService.selectUserById(Long.parseLong(userInfo.get("id")));
	    
	    if(users==null) {
	    	userService.insertUser(newUsers, userInfo);
	    }    
	    
  	    //세션에 저장
	    session.setAttribute("userInfo", userInfo); 
	    
	    //로그인 전 이동하려고 했던 페이지
	    String targetPage = session.getAttribute("targetPage")+"";
	    session.removeAttribute("targetPage");
	    
		return "redirect:"+targetPage;//포워딩으로 페이지 이동시 콜백 URL이 남아있어 새로고침시 에러
	}
	
	
}
