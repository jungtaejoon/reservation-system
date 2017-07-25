package kr.or.connect.dao;

public class ProductSqls {
    final static String SELECT_BY_ID = "select id, category_id, name, description, sales_start, sales_end, sales_flag, event, create_date, modify_date from product where id = :id";
    final static String UPDATE_BY_ID = "update product set product = :product , completed = :completed where id = :id";
    final static String DELETE_BY_ID = "delete from product where id = :id";
    final static String SELECT = "select id, category_id, name, description, sales_start, sales_end, sales_flag, event, create_date, modify_date from product where sales_flag = 1 order by id limit 10";
    final static String COUNT_SALE = "select count(*) from product where sales_flag = 1";
    final static String COUNT_SALE_BY_CATEGORY = "select count(*) from product where sales_flag = 1 and category_id = :categoryId";
    
    
    final static String SELECT_SALE = "SELECT p.id, p.category_id, p.name, p.description, d.place_name, pi.file_id FROM product p \r\n" + 
    		"LEFT OUTER JOIN display_info d ON p.id = d.product_id\r\n" + 
    		"LEFT OUTER JOIN product_image pi ON p.id = pi.product_id AND pi.type = 1\r\n" + 
    		"INNER JOIN (SELECT id FROM product ORDER BY id LIMIT :start, 10) t1 ON t1.id = p.id\r\n" + 
    		"WHERE p.sales_flag = 1 ";
	public static final String SELECT_SALE_BY_CATEGORY = "SELECT p.id, p.category_id, p.name, p.description, d.place_name, pi.file_id FROM product p \r\n" + 
			"LEFT OUTER JOIN display_info d ON p.id = d.product_id\r\n" + 
			"LEFT OUTER JOIN product_image pi ON p.id = pi.product_id AND pi.type = 1\r\n" + 
			"INNER JOIN (SELECT id FROM product WHERE category_id = :categoryId ORDER BY id LIMIT :start, 10) t1 ON t1.id = p.id\r\n" + 
			"WHERE p.sales_flag = 1 ";
	public static final String SELECT_PRODUCT_DETAIL = "SELECT p.id, p.name, p.description, p.event, p.comment_count, p.avg_score, d.observation_time, d.place_name, d.place_street, d.place_lot,	d.tel, d.homepage, d.email, pd.content FROM product p left outer join display_info d on p.id = d.product_id left outer join product_detail pd on p.id = pd.product_id where p.id = :productId;";
	public static final String SELECT_IMAGES = "select pi.id, pi.file_id, pi.type from product_image pi inner join file f on pi.file_id = f.id where f.delete_flag = 0 and pi.product_id = :productId order by pi.type;";
	public static final String SELECT_PRICE_BY_ID = "SELECT pp.price_type, pp.price, pp.discount_rate FROM product p \r\n" + 
			"LEFT OUTER JOIN product_price pp ON p.id = pp.product_id\r\n" + 
			"WHERE p.id = :productId;";

}	