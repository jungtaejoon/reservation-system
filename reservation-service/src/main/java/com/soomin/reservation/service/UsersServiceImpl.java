package com.soomin.reservation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soomin.reservation.dao.UsersDao;
import com.soomin.reservation.domain.Users;
import com.soomin.reservation.dto.NaverLoginUser;

@Service
public class UsersServiceImpl implements UsersService{
	@Autowired
	UsersDao usersDao;
	
	@Override
	public long addNaverUser(NaverLoginUser naverUser) {
		// TODO Auto-generated method stub
		Users user = new Users();
		user.setSns_id(naverUser.getId());
		user.setUsername(naverUser.getName());
		user.setEmail(naverUser.getEmail());
		user.setNickname(naverUser.getNickname());
		user.setAdmin_flag(0);
		
		if(!usersDao.check(Long.parseLong(user.getSns_id()))){
			return usersDao.insert(user);
		}
		else {
			return usersDao.update(user);
		}
	}
}
