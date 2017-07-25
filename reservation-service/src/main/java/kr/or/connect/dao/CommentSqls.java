package kr.or.connect.dao;

public class CommentSqls {
	static final String SELECT_BY_PRODUCT_ID = "SELECT ruc.id, ruc.score, ruc.comment, u.username, ruc.create_date, ruc.image_count, ruci.file_id FROM reservation_user_comment ruc\r\n" + 
			"INNER JOIN users u ON ruc.user_id = u.id\r\n" + 
			"LEFT OUTER JOIN reservation_user_comment_image ruci ON ruc.id = ruci.reservation_user_comment_id\r\n" + 
			"WHERE ruc.product_id = :productId\r\n" + 
			"GROUP BY ruc.id\r\n" + 
			"LIMIT :start, :amount";
	public static final String SELECT_COMMENT_IMAGES = "SELECT r.file_id FROM reservation_user_comment_image r \r\n" + 
			"INNER JOIN file f on r.file_id = f.id \r\n" + 
			"WHERE f.delete_flag = 0 \r\n" + 
			"AND r.reservation_user_comment_id = :id;";
	public static final String COUNT_COMMENT_IMAGES = "SELECT image_count FROM reservation_user_comment WHERE id = :id"; 
}
