package kr.or.connect.reservation.dao;

public class ProductSqls {


	final static String SELECT_ALL = "SELECT p.id, p.name, p.description, d.place_name "
			 						+ "FROM product p, display_info d "
			 						+ "WHERE p.id = d.product_id order by p.id";
	
	final static String SELECT_BY_CATEGORY_ID = "SELECT p.id, p.name, p.description, d.place_name "
									+ "FROM product p, display_info d "
									+ "WHERE p.id = d.product_id and category_id = :categoryId order by p.id";
	
	final static String SELECT_MAIN_IMAGE_BY_PRODUCT_ID = "SELECT f.file_name, f.save_file_name, f.file_length, f.content_type, f.delete_flag "
									+ "FROM file f, product_image pi, product p "
									+ "WHERE p.id = pi.product_id AND pi.file_id = f.id AND p.id= :id AND pi.type=1";
	
	final static String SELLECT_SUB_IMAGE_BY_PRODUCT_ID = "SELECT f.file_name, f.save_file_name, f.file_length, f.content_type, f.delete_flag "
									+ "FROM file f, product_image pi, product p "
									+ "WHERE p.id = pi.product_id AND pi.file_id = f.id AND p.id= :id AND pi.id = :imageId";

	final static String SELECT_BY_ID = "SELECT p.name, p.description, p.sales_start, p.sales_end, p.sales_flag, p.event, "
									+ "d.observation_time, d.display_start, d.display_end, d.place_name, d.place_lot, "
									+ "d.place_street, d.tel, d.homepage, d.email FROM product p, display_info d "
									+ "WHERE p.id = d.product_id AND p.id = :id";
	
	final static String SELECT_IMAGE_ID_BY_PRODUCT_ID = "SELECT id FROM product_image WHERE product_id = :id order by type desc, id asc";
}
