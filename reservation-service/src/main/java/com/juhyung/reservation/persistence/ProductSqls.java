package com.juhyung.reservation.persistence;

public class ProductSqls {

	final static String SELECT_LIST_PAGE = 
			"select p.id, p.name, p.description, p.event, d.place_name, d.place_lot, d.place_street, pi.file_id "
			+ "from product as p, display_info as d, product_image as pi "
			+ "where p.id = d.product_id and p.id=pi.product_id and pi.type = 1 "
			+ "order by p.sales_end desc, p.create_date "
			+ "limit :page, :perNum";
	final static String SELECT_LIST_BY_CATEGORY =
			"select p.id, p.name, p.description, p.event, d.place_name, d.place_lot, d.place_street, pi.file_id "
			+ "from product as p, display_info as d, product_image as pi "
			+ "where p.id = d.product_id and p.id=pi.product_id and p.category_id = :category_id and pi.type = 1 and pi.type=1 "
			+ "order by p.sales_end desc, p.create_date "
			+ "limit :page, :perNum";
	final static String SELECT_COUNT_OF_SALE_PRODUCT =
			// "select * from product where sales_flag = 1";
			"select count(*) from product where sales_flag = 0";
	
	final static String SELECT_COUNT_OF_SALE_PRODUCT_BY_CATEGORY =
			// "select * from product where sales_flag = 1";
			"select count(*) from product where sales_flag = 0 and category_id= :id";
	
	final static String SELECT_LIST_PROMOTION =
			"select * from product where sales_end > now() "
			+ "order by sales_end desc, create_date";

	final static String SELECT_DETAIL_PRODUCT_BY_ID = 
			"select * from product as p, product_detail as pd, display_info as di "
			+ "where di.product_id =p.id and pd.product_id = p.id and p.id= :id";
	
	final static String SELECT_PRICE_BY_PRODUCT =
			"select price_type, price, discount_rate from product_price where product_id= :id";
}
