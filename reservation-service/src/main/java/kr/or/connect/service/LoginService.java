package kr.or.connect.service;

import javax.servlet.http.*;

import kr.or.connect.domain.*;

public interface LoginService {
	public User loginCheck(HttpServletRequest request, HttpServletResponse response);
}
