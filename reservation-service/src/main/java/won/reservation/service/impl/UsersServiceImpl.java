package won.reservation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import won.reservation.dao.UsersDao;
import won.reservation.domain.Users;
import won.reservation.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService {

	private UsersDao dao;
	
	@Autowired
	public UsersServiceImpl(UsersDao dao) {
		this.dao = dao;
	}
	
	@Override
	public Users get(Integer id) {
		return dao.select(id);
	}
	
	@Override
	public Users get(String snsId, String snsType) {
		return dao.select(snsId, snsType);
	}

	@Override
	public int add(Users user) {
		return dao.insert(user);
	}

	
}
