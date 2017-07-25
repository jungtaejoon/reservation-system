package won.reservation.api;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import net.minidev.json.JSONObject;
import won.reservation.domain.Users;
import won.reservation.dto.NaverLoginUser;
import won.reservation.dto.NaverLoginUserResult;
import won.reservation.service.UsersService;

@Controller
@RequestMapping("/api/users")
public class UsersController {
	static final String CLIENT_ID = "7HYSSZyvxLo0lyAcabtI";
	static final String CLIENT_SECRET = "f4xa_X8CdI";
			
	private UsersService service;
	
	@Autowired
	public UsersController(UsersService service) {
		this.service = service;
	}
	
	@GetMapping
	public String getUrl(HttpSession session) {
		SecureRandom random = new SecureRandom();
		String redirectURI = "";
		try {
			redirectURI = URLEncoder.encode("http://localhost:8080/api/users/loginCallBack", "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String state = new BigInteger(130, random).toString();
		String apiURL = "https://nid.naver.com/oauth2.0/authorize?response_type=code";
		apiURL += "&client_id=" + CLIENT_ID;
		apiURL += "&redirect_uri=" + redirectURI;
		apiURL += "&state=" + state;
		session.setAttribute("state", state);
		return "redirect:"+apiURL;
	}
	

	@GetMapping("/loginCallBack")
	public String test(HttpServletRequest req, HttpSession session) {
		String code = req.getParameter("code");
		String state = req.getParameter("state");
		
		if(session.getAttribute("state").equals(state)) {
			try {
				String redirectURI = URLEncoder.encode("/api/users/loginCallBack", "UTF-8");
				String apiURL = "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code";
				apiURL += "&client_id=" + CLIENT_ID;
				apiURL += "&client_secret=" + CLIENT_SECRET;
				apiURL += "&redirect_uri=" + redirectURI;
				apiURL += "&code=" + code;
				apiURL += "&state=" + state;
				
				String accessToken = "";
				//String refreshToken = "";
				 
				 RestTemplate rest = new RestTemplate();
				 ResponseEntity<JSONObject> response = null;
		         response = rest.exchange(apiURL, HttpMethod.GET, null, JSONObject.class);
		         JSONObject obj = response.getBody();
		       
		         accessToken = (String)obj.get("access_token");
		         //refreshToken = (String)obj.get("refresh_token");
				 if(response.getStatusCodeValue() == 200) {
					 NaverLoginUser user = getProfile(accessToken);
					 if(user != null) {
						 String snsType = "naver";
						 Users joinedUser = service.get(user.getId(), snsType);
						 if(joinedUser == null) {
							 Users newUser = new Users();
							 newUser.setUserName(user.getName());
							 newUser.setEmail(user.getEmail());
							 newUser.setNickName(user.getNickname());
							 newUser.setSnsId(user.getId());
							 newUser.setSnsType(snsType);
							 newUser.setSnsProfile(user.getProfileImage());
							 newUser.setAdminFlag(0);
							 newUser.setCreateDate(new Timestamp(System.currentTimeMillis()));
							 newUser.setModifyDate(new Timestamp(System.currentTimeMillis()));
							 int result = service.add(newUser);
							 session.setAttribute("userId", result);
						 }else {
							 session.setAttribute("userId", joinedUser.getId());
						 }
						 session.setAttribute("loginStatus", "success");
					 }
				 }else {
					 return "redirect:/";
				 }
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			return "redirect:/myreservation";
		}
		return "redirect:/";
	}
	
	public NaverLoginUser getProfile(String accessToken) {
		NaverLoginUser user = null;
		String apiURL = "https://openapi.naver.com/v1/nid/me";
		RestTemplate rest = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "bearer "+accessToken);
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
		
		ResponseEntity<NaverLoginUserResult> responseEntity = rest.exchange(apiURL, HttpMethod.GET, requestEntity, new ParameterizedTypeReference<NaverLoginUserResult>(){});
		if("success".equals(responseEntity.getBody().getMessage())){
			user = responseEntity.getBody().getResponse();
		}
		return user;
		
		// 바로 NaverLoginUser정보만 가져올때
		//ResponseEntity<NaverLoginUser> re = rest.exchange(apiURL, HttpMethod.GET, re, new ParameterizedTypeReference<NaverLoginUser>(){});
		//NaverLoginUser resp = re.getBody().getEmail();
       
	}
}
