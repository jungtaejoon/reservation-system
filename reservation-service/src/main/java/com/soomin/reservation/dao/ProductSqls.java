package com.soomin.reservation.dao;

public class ProductSqls {
	final static String SELECT_PROMOTION = "SELECT name, event FROM product";
	final static String COUNT_PRODUCT_ALL = "SELECT COUNT(id) FROM product";
	final static String COUNT_PRODUCT_BY_CATEGORY = "SELECT COUNT(id) FROM product WHERE category_id=:category_id";
	final static String SELECT_PRODUCT_ALL = "SELECT name, description FROM product LIMIT 10 OFFSET :offset";
	final static String SELECT_PRODUCT_BY_CATEGORY = "SELECT name, description FROM product WHERE category_id=:category_id LIMIT 10 OFFSET :offset";
}
