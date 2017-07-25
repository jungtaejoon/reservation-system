package kr.or.connect.service;

import java.util.*;

import kr.or.connect.domain.*;

public interface UserService {
    public List<User> getAll();
    public User selectById(Long id);
    public User selectByEmail(String email);
    public User insert(User user);
    public int delete(Long id);
	public User update(User user);
}
