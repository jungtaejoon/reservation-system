package kr.or.connect.jy.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.connect.jy.dao.UsersDao;
import kr.or.connect.jy.domain.NaverResponse;
import kr.or.connect.jy.dto.Users;

@Service
public class UsersService {
	@Autowired
	UsersDao usersDao;
	
	public Integer insert(Users user){
		return usersDao.insert(user);
	}
	
	public Integer countByEmail(String email) {
		return usersDao.countByEmail(email);
	}
	
	public Users signUpAndgetUser(NaverResponse nr) {
		String email = nr.getEmail();
	    if(countByEmail(email) < 1){
		    Users user = new Users(nr.getEmail(), 
		    		nr.getNickname(),
		    		nr.getName(),
		    		new java.sql.Timestamp(new Date().getTime()),
		    		new java.sql.Timestamp(new Date().getTime()));
		    insert(user);
	    }
		return getUserByEmail(email);
	}
	
	public Users getUserByEmail(String email) {
		return usersDao.selectByEmail(email);
	}
}

//TypeReference<HashMap<String,Object>> typeRef = new TypeReference<HashMap<String,Object>>() {};
//myProfile = mapper.readValue(response.toString(), typeRef);
//myProfile = (HashMap<String, Object>) myProfile.get("response");
