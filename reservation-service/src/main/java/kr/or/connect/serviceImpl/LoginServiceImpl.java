package kr.or.connect.serviceImpl;

import javax.servlet.http.*;

import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import kr.or.connect.domain.*;
import kr.or.connect.service.*;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {

//	@Autowired
//	private LoginDao loginDao;
	
	@Override
	public User check(HttpServletRequest request, HttpServletResponse response) {
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
