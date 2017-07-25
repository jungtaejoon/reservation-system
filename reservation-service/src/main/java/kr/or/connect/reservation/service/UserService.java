package kr.or.connect.reservation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.reservation.dao.UserDao;
import kr.or.connect.reservation.domain.User;

@Service
public class UserService {
	
	UserDao userDao;
	
	public UserService() {}
	@Autowired
	public UserService(UserDao userDao) {
		this.userDao = userDao;
	}

    @Transactional(readOnly = true)
    public User get(Integer id) {
        return userDao.getById(id);
    }
	

    @Transactional(readOnly = true)
    public List<User> getAll() {
        return userDao.getAll();
    }


    @Transactional(readOnly = false)
    public User add(User user){
        Integer add = userDao.add(user).intValue();
        user.setId(add);
        System.out.println(user);
        return user;
    }

    @Transactional(readOnly = false)
    public Integer delete(Integer id) {
        return userDao.delete(id);
    }

    @Transactional(readOnly = false)
    public Integer update(User user) {
        return userDao.update(user);
    }
    
    @Transactional(readOnly = true)
    public Boolean existByNaverId(Integer naverId) {
    	if( userDao.existByNaverId(naverId) == 0 ) {
    		return false;
    	} else {
    		return true;
    	}
    }
    
    @Transactional(readOnly = true)
    public User getByNaverId(Integer naverId) {
        return userDao.getByNaverId(naverId);
    }
    
    @Transactional(readOnly = false)
    public Integer updateByNaverId(User user) {
        return userDao.updateByNaverId(user);
    }
}
