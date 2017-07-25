package kr.or.connect.jy.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.or.connect.jy.domain.NaverResponse;
import kr.or.connect.jy.domain.NaverToken;
import kr.or.connect.jy.dto.Users;
import kr.or.connect.jy.service.NaverLoginService;
import kr.or.connect.jy.service.UsersService;

@Controller
public class LoginController {
	private NaverLoginService naverLoginService;
	private UsersService usersService;
	
	@Autowired
	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}

	@Autowired
	public void setNaverLoginService(NaverLoginService naverLoginService) {
		this.naverLoginService = naverLoginService;
	}

	@GetMapping("/naver_callback")
	public String callback(HttpServletRequest request, HttpSession session) {
		String clientId = "8MZOYydXJnYsvoXzMzaU";// 애플리케이션 클라이언트 아이디값";
		String clientSecret = "faTHN882I1";// 애플리케이션 클라이언트 시크릿값";
		String code = request.getParameter("code");
		String state = request.getParameter("state");
		String redirectURI = null;
		try {
			redirectURI = URLEncoder.encode("http://127.0.0.1:8080", "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String apiURL;
		apiURL = "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code&";
		apiURL += "client_id=" + clientId;
		apiURL += "&client_secret=" + clientSecret;
		apiURL += "&redirect_uri=" + redirectURI;
		apiURL += "&code=" + code;
		apiURL += "&state=" + state;
		String access_token = "";
		String refresh_token = "";
		
		try { // RESTTemplate이 하는거.
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			int responseCode = con.getResponseCode();
			BufferedReader br;
			
			if (responseCode == 200) { // 정상 호출
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else { // 에러 발생
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			String inputLine;
			StringBuffer res = new StringBuffer();
			while ((inputLine = br.readLine()) != null) {
				res.append(inputLine);
			}
			br.close();
			if (responseCode == 200) {
				NaverToken naverToken = new ObjectMapper().readValue(res.toString(), NaverToken.class);
				NaverResponse nr = naverLoginService.getUserProfile(naverToken.getAccessToken());

				Users user = usersService.signUpAndgetUser(nr);	// 회원 DB에 저장하고 유저 정보 받아옴
				
				session.setAttribute("user", user);
			}
		} catch (Exception e) {
			System.out.println(e);
			return "redirect:/";
		}
		
		return "redirect:/myreservation";
	}

}
