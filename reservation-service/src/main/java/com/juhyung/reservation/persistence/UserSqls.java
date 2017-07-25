package com.juhyung.reservation.persistence;

public class UserSqls {

	static final String CHECK_USER_VAILD = 
			"select id from users where email= :email";
	
	static final String SELECT_USER_INFO_BY_ID =
			"select username, email, tel from users where id= :id";
}
