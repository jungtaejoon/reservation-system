package kr.or.connect.reservation.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class LoginService {

	private final static String USER_PROFILE_CHECK_API_URL = "https://openapi.naver.com/v1/nid/me";
	
	//회원 프로필 조회
	public HashMap<String,String> selectUserProfile(String header) {
		HashMap<String,String> userInfo = null;
	    StringBuffer responseBuffer = new StringBuffer();
	    try {
            URL userProfileCheckAPIURL = new URL(USER_PROFILE_CHECK_API_URL);
            HttpURLConnection con = (HttpURLConnection)userProfileCheckAPIURL.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Authorization", header);
            int responseCode = con.getResponseCode();
            BufferedReader br;
	            
            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 에러 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            
            String inputLine;
            while ((inputLine = br.readLine()) != null) {
            	responseBuffer.append(inputLine);
            }
            br.close();
            
            JSONObject profileJson = new JSONObject(responseBuffer.toString());
            
            //유저 상세 정보
      		ObjectMapper mapper = new ObjectMapper();  
      	    TypeReference<HashMap<String,String>> typeRef = new TypeReference<HashMap<String,String>>() {};

      	    userInfo = mapper.readValue(profileJson.get("response")+"", typeRef);
      	    
        } catch (Exception e) {
            System.out.println(e);
        }
	    
  	    return userInfo;
	}
}
