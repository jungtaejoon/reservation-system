package kr.or.connect.jy.dao;

public class UsersSqls {
	final static String SELECT_BY_EMAIL = "select id, username, email, tel, nickname, "
			+ "sns_id, sns_type, sns_profile, "
			+ "create_date, modify_date from users "
			+ "where email = :email";
}
