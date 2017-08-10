package dunkirk.reservation.sql;

public class CommentSqls {
	
	public static final String GET_LIST_BY_PRODUCT = "SELECT ruc.id, ruc.comment, ruc.score, ruc.create_date, u.nickname, IFNULL(ruci.file_id, 0) as thumbnailFileId " + 
			"FROM reservation_user_comment ruc " + 
			"INNER JOIN users u ON ruc.user_id = u.id " + 
			"LEFT OUTER JOIN reservation_user_comment_image ruci ON ruc.id = ruci.reservation_user_comment_id " + 
			"WHERE ruc.product_id = :productId " + 
			"GROUP BY ruc.id " + 
			"ORDER BY ruc.create_date " + 
			"LIMIT :page, :limit";

}
