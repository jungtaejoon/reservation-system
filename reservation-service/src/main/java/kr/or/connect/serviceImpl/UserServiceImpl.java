package kr.or.connect.serviceImpl;

import java.sql.*;
import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import kr.or.connect.dao.*;
import kr.or.connect.domain.*;
import kr.or.connect.service.*;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	private UserDao userDao;
	
	@Autowired
	public UserServiceImpl(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User selectById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User selectByEmail(String email) {
		return userDao.selectByEmail(email);
	}

	@Override
	public User insert(User user) {
		user.setCreateDate(new Timestamp(System.currentTimeMillis()));
		user.setModifyDate(new Timestamp(System.currentTimeMillis()));
		return userDao.insert(user);
	}

	@Override
	public int delete(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User update(User user) {
		user.setModifyDate(new Timestamp(System.currentTimeMillis()));
		return userDao.update(user);
	}

}
