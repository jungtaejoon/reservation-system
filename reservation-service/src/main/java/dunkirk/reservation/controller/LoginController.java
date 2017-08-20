package dunkirk.reservation.controller;

import dunkirk.reservation.domain.NaverLoginUser;
import dunkirk.reservation.domain.NaverLoginUserResult;
import dunkirk.reservation.domain.User;
import dunkirk.reservation.service.UserService;
import dunkirk.reservation.util.GetStateUtil;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestOperations;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Value("${naver.login.client.id.query}")
    private String clientIdQuery;

    @Value("${naver.login.client.secret.query}")
    private String clientSecretQuery;

    @Value("${naver.login.oauth.authorize.url}")
    private String naverOauthAuthorizeUrl;

    @Value("${naver.login.oauth.token.url}")
    private String naverOauthTokenUrl;

    @Value("${naver.login.oauth.user.url}")
    private String naverOauthUserUrl;

    private RestOperations restOperations;
    private UserService userService;
    private GetStateUtil getStateUtil;

    @Autowired
    public LoginController(RestOperations restOperations, UserService userService, GetStateUtil getStateUtil) {
        super();
        this.restOperations = restOperations;
        this.userService = userService;
        this.getStateUtil = getStateUtil;
    }

    @GetMapping
    public void login(HttpServletResponse response, HttpSession session) {
        String state = getStateUtil.getState();
        session.setAttribute("state", state);
        String redirectUri = null;
        try {
            redirectUri = URLEncoder.encode("http://localhost:8080/login/callback", "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try {
            response.sendRedirect(naverOauthAuthorizeUrl + clientIdQuery + "&redirect_uri=" + redirectUri + "&state=" + state);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @GetMapping("/callback")
    public String callback(@RequestParam(value = "error", required = false) String error,
                           @RequestParam(value = "code", required = false) String code,
                           @RequestParam(value = "state", required = false) String resultState,
                           HttpSession session, HttpServletResponse response) {
        if (error != null) {
            return "redirect:/?error=true";

        } else if (!resultState.equals(session.getAttribute("state"))) {
            return "redirect:/?state-error=true";

        } else {
            setUserToSession(resultState, code, session, response);
            return "redirect:" + session.getAttribute("path");

        }
    }

    private void setUserToSession(String state, String code, HttpSession session, HttpServletResponse response) {
        JSONObject token = getNaverOauthToken(state, code);
        ResponseEntity<NaverLoginUserResult> result = getNaverOauthUserResult(token);
        if (result != null && result.getStatusCode() == HttpStatus.OK) {
            NaverLoginUser naverUser = result.getBody().getResponse();
            User checkingUser = userService.getByEmail(naverUser.getEmail());

            if (checkingUser == null) {
                checkingUser = userService.add(naverUser.convertToUser());
            }

            switch (checkingUser.checkNaverUser(naverUser)) {
                case User.SAME:
                    break;

                case User.NEED_UPDATE:
                    checkingUser = userService.modify(naverUser.convertToUser());
                    break;

            }
            session.setAttribute("user", checkingUser);
        } else {
            try {
                response.sendRedirect("/");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private JSONObject getNaverOauthToken(String state, String code) {
        String url = naverOauthTokenUrl + clientIdQuery + clientSecretQuery + "&state=" + state + "&code=" + code;
        return restOperations.getForObject(url, JSONObject.class);
    }

    private ResponseEntity<NaverLoginUserResult> getNaverOauthUserResult(JSONObject token) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token.get("token_type") + " " + token.get("access_token"));
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
        return restOperations.exchange(naverOauthUserUrl, HttpMethod.GET, entity, NaverLoginUserResult.class);
    }
}
