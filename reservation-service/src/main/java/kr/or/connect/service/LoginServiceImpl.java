package kr.or.connect.service;

import javax.servlet.http.*;

import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import kr.or.connect.domain.*;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {

//	@Autowired
//	private LoginDao loginDao;
	
	@Override
	public User loginCheck(HttpServletRequest request, HttpServletResponse response) {
		User user = null;
		Boolean logged = false;
		HttpSession session = request.getSession();
		if(session.getAttribute("loginOK") != null) logged = true;
		if(logged) {
			user = new User("jungtaejoon");
			user.setId(999L);
		}
		return user;
	}
	

	

}
