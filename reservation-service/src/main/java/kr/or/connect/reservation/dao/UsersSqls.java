package kr.or.connect.reservation.dao;

public class UsersSqls {
	final static String SELECT_USERID_BY_SNS_ID = 
			"SELECT id"
			+ " FROM users "
			+ " WHERE sns_id = :sns_id";
	
	final static String SELECT_EXIST_USER = 
			"SELECT count(id) AS counter"
			+ " FROM users "
			+ " WHERE sns_id = :sns_id";
	
	final static String SELECT_USER_BY_ID =
			"SELECT U.id, U.email, U.nickname, U.tel, U.username "
			+ " FROM users AS U "
			+ " WHERE U.id = :id";
}
