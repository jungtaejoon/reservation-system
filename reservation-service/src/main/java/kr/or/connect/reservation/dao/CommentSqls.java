package kr.or.connect.reservation.dao;

public class CommentSqls {

	final static String SELECT_COMMENT_BY_PRODUCTID = "SELECT id, user_id, score, comment, DATE_FORMAT(create_date, \"%Y.%m.%d\") as create_date FROM reservation_user_comment WHERE product_id = 1 limit 0,3";
	final static String SELECT_COMMENTIMAGE_BY_ID = "SELECT f.file_name, f.save_file_name, f.file_length, f.content_type FROM file f, reservation_user_comment_image ruci"
													+" WHERE f.id = ruci.file_id and ruci.reservation_user_comment_id = :id";
	final static String SELECT_COMMENT_COUNT_BY_PRODUCTID = "SELECT round(avg(score), 1) as avg, count(*) as count FROM reservation_user_comment WHERE product_id = :id ";
}
