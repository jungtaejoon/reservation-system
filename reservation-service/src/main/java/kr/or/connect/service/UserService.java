package kr.or.connect.service;

import java.util.*;

import kr.or.connect.domain.*;

public interface UserService {
    public List<User> getAll();
    public User selectById(Long id);
    public User selectByUsername(String username);
    public User insert(User user);
    public int delete(Long id);
}
