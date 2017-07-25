package kr.or.connect.controller;

import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.*;

import kr.or.connect.domain.*;
import kr.or.connect.service.*;
import net.minidev.json.*;

@Controller
@RequestMapping("/login")
public class LoginController {
	private static final String CLIENT_ID = "UT0zsTGjviSL7f6l7c1Q";
	private static final String CLIENT_SECRET = "ZXKknx3E3I";
	private static final String NAVER_OAUTH_TOKEN_URL = "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code&client_id="
			+ CLIENT_ID + "&client_secret=" + CLIENT_SECRET + "&state=";
	private static final String NAVER_OAUTH_USER_URL = "https://openapi.naver.com/v1/nid/me";

	private RestOperations restTemplate;
	private UserService userService;
	
	@Autowired
	public LoginController(RestOperations restTemplate, UserService userService) {
		super();
		this.restTemplate = restTemplate;
		this.userService = userService;
	}

	@GetMapping(value = {"/{requestURI}", "/{requestURI}/{id}"})
	public String login(@PathVariable String requestURI,
						@PathVariable(required = false) Long id,
						@RequestParam(value = "error", required = false) String error,
						@RequestParam(value = "code", required = false) String code,
						@RequestParam(value = "state", required = false) String resultState, 
						HttpSession session, Model model) {
		if(id != null) requestURI += "/" + id;
		if (error != null) {
			return "redirect:/" + requestURI + "?error=true";
			
		} else if (!resultState.equals(session.getAttribute("state"))) {
			return "redirect:/" + requestURI + "?state-error=true";
			
		} else {
			getNaverUser(resultState, code, session, model);
			return "redirect:/" + requestURI;
			
		}
	}
	
	public void getNaverUser(String state, String code, HttpSession session, Model model) {
		String url = NAVER_OAUTH_TOKEN_URL + state + "&code=" + code;
		JSONObject json = restTemplate.getForObject(url, JSONObject.class);
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", json.get("token_type") + " " + json.get("access_token"));
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		ResponseEntity<NaverLoginUserResult> result = restTemplate.exchange(NAVER_OAUTH_USER_URL, HttpMethod.GET, entity,
				NaverLoginUserResult.class);
		
		if (result != null && result.getStatusCode() == HttpStatus.OK) {
			NaverLoginUser naverUser = result.getBody().getResponse();
			User checkingUser = userService.selectByEmail(naverUser.getEmail());
			
			if(checkingUser == null) {
				checkingUser = userService.insert(naverUser.convertToUser());
			} 
			
			switch (checkingUser.checkNaverUser(naverUser)) {
			case User.SAME:
				break;
				
			case User.NEED_UPDATE:
				checkingUser = userService.update(naverUser.convertToUser());
				break;
				
			}
			session.setAttribute("email", checkingUser.getEmail());
		} 
	}
}
