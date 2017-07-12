package kr.or.connect.reservation.dao;

public class ProductSqls {
	final static String SELECT_BY_CATEGORY_ID = 
			"SELECT P.id, P.category_id, P.name, P.description, DI.place_name, F.file_name, F.save_file_name"
			+ " FROM product AS P"
			+ " JOIN display_info AS DI"
			+ " ON DI.id = P.id"
			+ " JOIN product_image AS PI"
			+ " ON P.id = PI.product_id"
			+ " JOIN file AS F"
			+ " ON F.id = PI.file_id"
			+ " WHERE P.category_id = :category_id"
			+ " LIMIT :offset, :limit";
	
	final static String SELECT_ALL = 
			"SELECT P.id, P.category_id, P.name, P.description, DI.place_name, F.file_name, F.save_file_name"
			+ " FROM product AS P"
			+ " JOIN display_info AS DI"
			+ " ON DI.id = P.id"
			+ " JOIN product_image AS PI"
			+ " ON P.id = PI.product_id"
			+ " JOIN file AS F"
			+ " ON F.id = PI.file_id"
			+ " LIMIT :offset, :limit";
	
	final static String SELECT_TOTAL_COUNT_BY_CATEGORY_ID =
			"SELECT count(*) AS totalCount"
			+ " FROM product AS P"
			+ " JOIN display_info AS DI"
			+ " ON DI.id = P.id"
			+ " JOIN product_image AS PI"
			+ " ON P.id = PI.product_id"
			+ " JOIN file AS F"
			+ " ON F.id = PI.file_id"
			+ " WHERE P.category_id = :category_id";
	
	final static String SELECT_TOTAL_COUNT =
			"SELECT count(*) AS totalCount"
			+ " FROM product AS P"
			+ " JOIN display_info AS DI"
			+ " ON DI.id = P.id"
			+ " JOIN product_image AS PI"
			+ " ON P.id = PI.product_id"
			+ " JOIN file AS F"
			+ " ON F.id = PI.file_id";
}
