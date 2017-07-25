package com.juhyung.reservation.persistence;

public class CommentSqls {
	static final String SELECT_COMMENT_BY_PRODUCT_ID =
			"select comment.*, product.name as title "
			+ "from reservation_user_comment as comment, product "
			+ "where comment.product_id = product.id and product.id= :id";
	static final String SELECT_SAMPLE_COMMENT =
			"select comment.*, product.name as title "
			+ "from reservation_user_comment as comment, product "
			+ "where comment.product_id = product.id and product.id= :id "
			+ "limit :page, :perNum";
	static final String COUNT_COMMENTS =
			"select count(id) from reservation_user_comment where product_id= :id";
	static final String AVERAGE_SCORE =
			"select avg(score) from reservation_user_comment where product_id= :id";
}
