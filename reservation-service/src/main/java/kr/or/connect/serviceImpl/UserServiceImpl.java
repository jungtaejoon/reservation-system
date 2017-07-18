package kr.or.connect.serviceImpl;

import java.util.*;

import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import kr.or.connect.domain.*;
import kr.or.connect.service.*;

@Service
@Transactional
public class UserServiceImpl implements UserService {

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
	public User selectByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User insert(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
