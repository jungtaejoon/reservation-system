package dunkirk.reservation.sql;

public class ProductSqls {

	public static final String GET_LIST = 
			"SELECT p.id, p.name, p.description, di.place_name, pi.file_id" + 
			" FROM product p INNER JOIN display_info di ON p.id = di.product_id" + 
			" INNER JOIN product_image pi ON p.id = pi.product_id" + 
			" WHERE pi.type = 1 AND now() BETWEEN p.sales_start AND p.sales_end" + 
			" LIMIT :page, 10";
	public static final String GET_LIST_BY_CATEGORY = 
			"SELECT p.id, p.name, p.description, di.place_name, pi.file_id" + 
			" FROM product p INNER JOIN display_info di ON p.id = di.product_id" + 
			" INNER JOIN product_image pi ON p.id = pi.product_id" + 
			" WHERE pi.type = 1 AND now() BETWEEN p.sales_start AND p.sales_end AND p.category_id = :category_id" + 
			" LIMIT :page, 10";
	public static final String GET_DETAIL = 
			"SELECT p.id, p.name, p.description, p.sales_flag, p.event, pd.content, di.observation_time, di.display_start," +
			" di.display_end, di.place_name, di.place_lot, di.place_street, di.tel, di.homepage, di.email, p.avg_score, p.review_count " + 
			" FROM product p" + 
			" INNER JOIN product_detail pd ON p.id = pd.product_id" + 
			" INNER JOIN display_info di ON p.id = di.product_id" + 
			" WHERE p.id = :id";
	public static final String GET_FOR_RESERVATION =
			"SELECT p.id, p.name, di.observation_time, di.display_start, di.display_end, di.place_street, di.place_lot, pi.file_id" + 
			" FROM product p INNER JOIN display_info di ON p.id = di.product_id" + 
			" INNER JOIN product_image pi ON p.id = pi.product_id" + 
			" WHERE p.id = :id AND pi.type = 1";
}
