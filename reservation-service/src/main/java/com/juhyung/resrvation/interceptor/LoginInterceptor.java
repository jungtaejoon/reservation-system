package com.juhyung.resrvation.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.juhyung.reservation.domain.User;

@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {

	private static final String LOGIN = "login";

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		HttpSession session = request.getSession();

		if (session.getAttribute(LOGIN) == null) {
			response.sendRedirect("/login");
		}
		return true;
	}

//	@Override
//	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
//			ModelAndView modelAndView) throws Exception {
//		
//		HttpSession session = request.getSession();
//		ModelMap modelMap = modelAndView.getModelMap();
//		Object user = modelMap.get("user");
//
//		if(session.getAttribute(LOGIN) != null){
//			session.setAttribute(LOGIN, user);
//			response.sendRedirect("/myreservation");
//		}
//		
//	}
	
	
}
