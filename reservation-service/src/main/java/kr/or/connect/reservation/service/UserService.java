package kr.or.connect.reservation.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.connect.reservation.dao.UserDAO;
import kr.or.connect.reservation.domain.Users;

@Service
public class UserService {

	@Autowired
	private UserDAO dao;
	
	public Long insertUser(Users users, HashMap<String,String> userInfo) {
		users.setId(Long.parseLong(userInfo.get("id")));
    	users.setEmail(userInfo.get("email"));
    	users.setUserName(userInfo.get("name"));
    	users.setSnsId(userInfo.get("enc_id"));
    	
		return dao.insertUser(users);
	}
	
	public Users selectUserById(Long id) {
		System.out.println(id);
		Users users = dao.selectUserById(id);
		System.out.println(users);
		return users;
	}
}
