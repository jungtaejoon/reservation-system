package dunkirk.reservation.service.impl;

import dunkirk.reservation.dao.UserDao;
import dunkirk.reservation.domain.User;
import dunkirk.reservation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

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
    public User getByEmail(String email) {
        return userDao.getByEmail(email);
    }

    @Override
    public User add(User user) {
        user.setCreateDate(new Timestamp(System.currentTimeMillis()));
        user.setModifyDate(new Timestamp(System.currentTimeMillis()));
        return userDao.add(user);
    }

    @Override
    public User modify(User user) {
        user.setModifyDate(new Timestamp(System.currentTimeMillis()));
        return userDao.modify(user);
    }

}