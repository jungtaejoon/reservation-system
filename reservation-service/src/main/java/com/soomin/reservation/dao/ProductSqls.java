package com.soomin.reservation.dao;

public class ProductSqls {
	final static String SELECT_PROMOTION = "SELECT id, name, event FROM product";
	final static String COUNT_PRODUCT_ALL = "SELECT COUNT(*) FROM product";
	final static String COUNT_PRODUCT_BY_CATEGORY = "SELECT COUNT(*) FROM product WHERE category_id=:category_id";
	final static String SELECT_PRODUCT_ALL = "SELECT id, name, description FROM product LIMIT 10 OFFSET :offset";
	final static String SELECT_PRODUCT_BY_CATEGORY = "SELECT id, name, description FROM product WHERE category_id=:category_id LIMIT 10 OFFSET :offset";
	final static String SELECT_PRODUCT_DETAIL_BY_ID = "SELECT id, name, description, event, sales_end, sales_flag FROM product WHERE id=:id";
}
