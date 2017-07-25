package won.reservation.dao;

public class UsersSqls {
	static final String SELECT_BY_Id = "select * from users where id = :id";
	static final String SELECT_BY_SNS_ID = "select * from users where sns_id = :snsid and sns_type = :snstype";
}
