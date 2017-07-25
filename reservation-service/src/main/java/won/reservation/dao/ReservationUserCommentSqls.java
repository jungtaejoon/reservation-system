package won.reservation.dao;

public class ReservationUserCommentSqls {
	static final String SELECT_BY_PRODUCT_ID = "select c.id comment_id, c.comment, c.score, c.user_id, DATE_FORMAT(c.create_date, '%Y.%m.%d') visited_date, i.file_id temp_file_id " + 
			"from reservation_user_comment c " + 
			"left join reservation_user_comment_image i " + 
			"on c.id = i.reservation_user_comment_id " + 
			"where product_id = :productid " +
			"group by c.id ";
	
	static final String SCORE_AVG = "select avg(score) avg_score from reservation_user_comment where product_id = :productid";
}
