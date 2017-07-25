package kr.or.connect.reservation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.connect.reservation.dao.UsersDao;
import kr.or.connect.reservation.domain.Users;
import kr.or.connect.reservation.dto.NaverUserDto;
import kr.or.connect.reservation.utils.Utils;

@Service
public class NaverLoginServiceImpl implements NaverLoginService {

	@Autowired
	UsersDao dao;

	@Override
	public Users login(NaverUserDto naverUser) {

		long userId = 0;
		Users loginUser = null;

		if (naverUser != null && !"".equals(naverUser.getId())) {

			String snsId = naverUser.getId();

			// 기존 유저가 존재하는지 검증, (snsId로) snsType이 sns 로그인의 종류라면 같이 검증하는게 좋을듯
			long returnKey = dao.selectUserIdBySnsId(snsId);

			if (returnKey == 0) {
				loginUser = new Users();
				
				String email = naverUser.getEmail();
				String profileImage = naverUser.getProfileImage();
				String nickname = naverUser.getNickname();
				
				loginUser.setUsername(email.split("@")[0]);
				loginUser.setSnsId(snsId);
				loginUser.setAdminFlag(0);
				loginUser.setEmail((email != null) ? email : "");
				loginUser.setNickname((nickname != null) ? nickname : "");
				loginUser.setSnsProfile((profileImage != null) ? profileImage : "");
				loginUser.setCreateDate(Utils.getCurrentTimeStamp());

				// 유저 정보가 일치하는게 없으면 DB에 유저 등록
				userId = dao.insert(loginUser);
				
				return loginUser;
			} else {
				loginUser = dao.selectUsersById(returnKey);
			}
		}
		return loginUser;
	}
}
