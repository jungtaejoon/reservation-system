package kr.or.connect.reservation.config;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Map;

import org.json.XML;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import kr.or.connect.reservation.utils.Utils;

@Configuration
@PropertySource("classpath:/naverapi.properties")
public class NaverApiConfig {

	@Value("${naverapi.config.client-id}")
	private String clientId;

	@Value("${naverapi.config.client-secret}")
	private String clientSecret;

	@Value("${naverapi.login.request-url}")
	private String requestUrl;

	@Value("${naverapi.login.request-oauth-url}")
	private String reqestOauthUrl;

	@Value("${naverapi.login.login-callback-url}")
	private String loginCallbackUrl;

	@Value("${naverapi.login.request-user-info-url}")
	private String requestUserInfoUrl;

	// this bean needed to resolve ${property.name} syntax
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	/**
	 * 네아로에서 사용하는 state전용 생성 메서드
	 * 
	 * @return
	 */
	public String generateState() {
		SecureRandom state = new SecureRandom();
		return new BigInteger(130, state).toString(32);
	}
	
	/**
	 * 로그인 인증 콜백 URL 리턴 메서드
	 * 
	 * @param state
	 * @return
	 */
	public String getOauthCallbackURL(String state) {
		return requestUrl + "client_id=" + clientId + "&response_type=code" + "&redirect_uri=" + loginCallbackUrl
				+ "&state=" + state;
	}

	/**
	 * AccessToken 발급 받는 URL 리턴 메서드
	 * 
	 * @param state
	 * @param code
	 * @return
	 */
	public String getAccessTokenUrl(String state, String code) {
		return reqestOauthUrl + "client_id=" + clientId + "&client_secret=" + clientSecret
				+ "&grant_type=authorization_code" + "&state=" + state + "&code=" + code + "&service_provider=NAVER";
	}

	/**
	 * 다른아이디로 로그인 할 경우 재로그인 URL 리턴 메서드
	 */
	public String reAuthenticateUrl(String state) {
		return requestUrl + "client_id=" + clientId + "&response_type=code" + "&redirect_uri=" + loginCallbackUrl
				+ "&state=" + state + "&auth_type=reauthenticate";
	}

	public Map<String, String> getLoginedUserInfo(String token, String tokenType, String type) {
		String profileDataXml = Utils.getHtml(requestUserInfoUrl, tokenType + " " + token);

		org.json.JSONObject jsonObject = XML.toJSONObject(profileDataXml);
		org.json.JSONObject responseData = jsonObject.getJSONObject("data");

		Map<String, String> userMap = Utils.JSONStringToMap(responseData.get("response").toString());

		return userMap;
	}
}
