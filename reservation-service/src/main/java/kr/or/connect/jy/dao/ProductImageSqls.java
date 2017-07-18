package kr.or.connect.jy.dao;

public class ProductImageSqls {
	final static String SELECT_ALL = 
			"select * from PRODUCT_IMAGE";
	
	final static String SELECT_BY_PRODUCT_ID = 
			"select * from PRODUCT_IMAGE where product_id=:product_id";
}
