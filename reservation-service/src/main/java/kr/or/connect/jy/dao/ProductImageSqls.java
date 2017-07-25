package kr.or.connect.jy.dao;

public class ProductImageSqls {
	final static String SELECT_ALL = 
			"select * from PRODUCT_IMAGE";
	
	final static String SELECT_BY_PRODUCT_ID = 
			"select * from PRODUCT_IMAGE where product_id=:product_id";
	
	final static String SELECT_BY_PRODUCT_ID_FOR_DETAIL = 
			"select pi.id, p.name, p.description, pi.product_id, pi.file_id, "
			+ "f.user_id, pi.type, f.file_name, f.save_file_name "
			+ "from PRODUCT_IMAGE pi "
			+ "join file f on f.id=pi.file_id "
			+ "join product p on p.id=pi.product_id "
			+ "where pi.product_id=:product_id";
}
