package com.juhyung.reservation.persistence;

public class ProductSqls {

	//TODO paging처리 해야함
	final static String SELECT_LIST_PAGE = 
			"select p.id, p.name, p.description, p.event, d.place_name, d.place_lot, d.place_street " +
			"from product as p join display_info as d on p.id = d.product_id " +
			"order by p.sales_end desc, p.create_date " +
			"limit :page, :perNum";
	final static String SELECT_LIST_BY_CATEGORY =
			"select p.id, p.name, p.description, p.event, d.place_name, d.place_lot, d.place_street " +
			"from product as p join display_info as d on p.id = d.product_id " +
			"where p.category_id = :category_id " +
			"order by p.sales_end desc, p.create_date "+
			"limit :page, :perNum";
	//TODO product_image도 해주어야함
	final static String SELECT_DATEIL_BY_ID =
			"select * from product join product_detail join product_price where id= :id";
	
	final static String SELECT_COUNT_OF_SALE_PRODUCT =
//			"select * from product where sales_flag = 1";
			"select count(*) from product where sales_flag = 0";
	
	final static String SELECT_LIST_PROMOTION = 
			"select * from product where sales_end > now() " + 
			"order by sales_end desc, create_date";
	
} 