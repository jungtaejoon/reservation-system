package kr.or.connect.jy.dao;

public class CommentSqls {
	final static String SELECT_COMMENT_BY_PRODUCT_ID_RECENT_LIMIT3 = 
			"select ruc.id, "
			+ "ruc.user_id, "
			+ "ruc.score, "
			+ "ruc.comment, "
			+ "ruci.file_id, "
			+ "u.username, "
			+ "ruc.create_date, "
			+ "ruc.modify_date, "
			+ "count(1) as imgcount "
			+ "from reservation_user_comment ruc "
			+ "left outer join reservation_user_comment_image ruci on ruci.reservation_user_comment_id=ruc.id "
			+ "join users u on u.id=ruc.user_id "
			+ "where ruc.product_id=:product_id "
			+ "group by ruc.id "
			+ "order by ruc.create_date DESC "
			+ "LIMIT 3";
	
	final static String COUNT_COMMENT_BY_PRODUCT_ID = 
			"select count(1) "
			+ "from reservation_user_comment "
			+ "where product_id=:product_id";

	final static String SUM_SCORE_BY_PRODUCT_ID = 
			"select sum(score) "
			+ "from reservation_user_comment "
			+ "where product_id=:product_id";
	
	final static String SELECT_IMEAGE_BY_USER_COMMENT_ID = 
			"select ruc.id, ruc.user_id, ruci.id as comment_image_id, ruci.file_id, f.file_name "
			+ "from reservation_user_comment ruc "
			+ "join reservation_user_comment_image ruci on ruci.reservation_user_comment_id=ruc.id "
			+ "join file f on f.id=ruci.file_id "
			+ "where ruc.id=:user_comment_id";
}
