package com.soomin.reservation.dao;

public class CommentSqls {
	final static String COUNT_BY_PRODUCT_ID="SELECT ROUND(AVG(score), 2) score, COUNT(*) count FROM reservation_user_comment WHERE product_id=:product_id";
	final static String SELECT_BY_PRODUCT_ID=
			"SELECT comment.score score, comment.comment comment, comment.create_date create_date, product.name product_name, users.username user_name "
			+"FROM product, reservation_user_comment comment, users "
			+"WHERE product_id=1 AND comment.product_id=product.id AND comment.user_id=users.id LIMIT 3";
}
