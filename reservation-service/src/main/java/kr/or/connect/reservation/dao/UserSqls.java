package kr.or.connect.reservation.dao;

public class UserSqls {
	final static String SELECT_BY_ID = "select * from users where id = :id";
	final static String UPDATE_BY_ID = "update users set username= :username, email= :email, tel= :tel, nickname= :nickname, "
			+ " sns_id= :snsId, sns_type= :snsType, sns_profile= :snsProfile, modify_date= NOW(), naver_id = :naverId "
			+ " where id= :id";
	final static String DELETE_BY_ID = "delete from users where id = :id";
	final static String SELECT_ALL = "select * from users";
	
	final static String UPDATE_ADMIN_BY_ID = "update users set admin_flag= :adminFlag where id= :id";

	final static String UPDATE_BY_NAVER_ID = "update users set username= :username, email= :email, tel= :tel, nickname= :nickname, "
			+ " sns_id= :snsId, sns_type= :snsType, sns_profile= :snsProfile, modify_date= NOW() "
			+ " where naver_id= :naverId";
	
	final static String SELECT_BY_NAVER_ID = "select * from users where naver_id = :naverId";
	final static String EXISTS_BY_NAVER_ID = "select exists (select * from users where naver_id = :naverId) as success";
}
