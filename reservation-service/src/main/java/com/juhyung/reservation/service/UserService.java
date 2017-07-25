package com.juhyung.reservation.service;

import java.util.Map;

import com.juhyung.reservation.domain.User;

public interface UserService {

	public int setUser(Map<String, String> userMap) throws Exception;
	public User getUserById(int id);
}
