package connect.reservation.dao;

public class ProductInfoSqls {
	final static String endNum = "10";
	
	final static String COUNT_PRODUCT = "SELECT count(*) FROM product";
	final static String COUNT_CATEGORY_PRODUCT = "SELECT count(*) FROM product WHERE category_id = :category_id";
	final static String GET_MAIN_INFO = "SELECT s1.id product_id, s1.category_id, s1.name product_name, s1.description , s1.place_name, s2.file_name, s2.save_file_name "
			+ "FROM "
			+ "(select p.id, p.category_id, p.name, p.description, di.place_name  "
			+ "from product p, display_info di "
			+ "where p.id = di.product_id) s1 "
			+ "INNER JOIN "
			+ "(select p.id, f.file_name, f.save_file_name "
			+ "from product p, product_image pi, file f "
			+ "where p.id = pi.product_id and pi.file_id = f.id) s2 "
			+ "ON s1.id = s2.id "
			+ "ORDER BY s1.id "
			+ "LIMIT :start , "+endNum;
	final static String GET_CATEGORY_INFO = "SELECT s1.id product_id, s1.category_id, s1.name product_name, s1.description , s1.place_name, s2.file_name, s2.save_file_name "
			+ "FROM "
			+ "(select p.id, p.category_id, p.name, p.description, di.place_name  "
			+ "from product p, display_info di "
			+ "where p.id = di.product_id) s1 "
			+ "INNER JOIN "
			+ "(select p.id, f.file_name, f.save_file_name "
			+ "from product p, product_image pi, file f "
			+ "where p.id = pi.product_id and pi.file_id = f.id) s2 "
			+ "ON s1.id = s2.id "
			+ "WHERE s1.category_id = :categoryId "
			+ "ORDER BY s1.id "
			+ "LIMIT :start , "+endNum;
			
}

