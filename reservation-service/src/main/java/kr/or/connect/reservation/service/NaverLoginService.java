package kr.or.connect.reservation.service;

import kr.or.connect.reservation.domain.Users;
import kr.or.connect.reservation.dto.NaverUserDto;

public interface NaverLoginService {
	public Users login(NaverUserDto naverUser);
}
