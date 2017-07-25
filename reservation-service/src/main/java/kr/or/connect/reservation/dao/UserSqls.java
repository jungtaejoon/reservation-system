package kr.or.connect.reservation.dao;

public class UserSqls {

	final static String SELECT_USER_BY_ID = "SELECT id, username, email, tel, nickname, sns_id, sns_type, sns_profile, "
											+ "admin_flag, create_date, modify_date FROM USERS WHERE id = :id";
}
