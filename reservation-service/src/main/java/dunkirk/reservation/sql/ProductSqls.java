package dunkirk.reservation.sql;

public class ProductSqls {

	public static final String GET_LIST = "SELECT p.id, p.name, p.description, di.place_name, pi.file_id" + 
											" FROM product p INNER JOIN display_info di ON p.id = di.product_id" + 
											" INNER JOIN product_image pi ON p.id = pi.product_id" + 
											" WHERE pi.type = 1 AND now() BETWEEN p.sales_start AND p.sales_end" + 
											" LIMIT :start, 10";
	public static final String GET_LIST_BY_CATEGORY = "SELECT p.id, p.name, p.description, di.place_name, pi.file_id" + 
											" FROM product p INNER JOIN display_info di ON p.id = di.product_id" + 
											" INNER JOIN product_image pi ON p.id = pi.product_id" + 
											" WHERE pi.type = 1 AND now() BETWEEN p.sales_start AND p.sales_end AND p.category_id = :category_id" + 
											" LIMIT :start, 10";

}
