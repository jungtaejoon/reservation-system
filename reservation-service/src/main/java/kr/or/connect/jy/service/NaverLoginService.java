package kr.or.connect.jy.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.or.connect.jy.domain.NaverLoginResult;
import kr.or.connect.jy.domain.NaverResponse;

@Service
public class NaverLoginService {
	
	public NaverResponse getUserProfile(String accessToken) {
		String header = "Bearer " + accessToken; // Bearer 다음에 공백 추가
		try {
			String apiURL = "https://openapi.naver.com/v1/nid/me";
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Authorization", header);
			int responseCode = con.getResponseCode();
			BufferedReader br;
			if (responseCode == 200) { // 정상 호출
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else { // 에러 발생
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = br.readLine()) != null) {
				response.append(inputLine);
			}
			br.close();
		    
			ObjectMapper mapper = new ObjectMapper(); 
		    NaverLoginResult naverLogin = mapper.readValue(response.toString(), NaverLoginResult.class);
		    NaverResponse nr = naverLogin.getResponse();
		    
		    return nr;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
}
