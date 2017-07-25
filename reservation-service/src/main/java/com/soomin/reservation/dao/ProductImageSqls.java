package com.soomin.reservation.dao;

public class ProductImageSqls {
	final static String SELECT_REPRESENT_BY_PRODUCT_ID = "SELECT file_id FROM product_image WHERE product_id=:product_id AND type<=1";
	final static String SELECT_ONE_BY_PRODUCT_ID = "SELECT file_id FROM product_image WHERE product_id=:product_id AND type=0 LIMIT 1";
	final static String COUNT_BY_PRODUCT_ID = "SELECT COUNT(*) FROM product_image WHERE product_id=:product_id AND type<=1";
	final static String SELECT_ADDITIONAL_BY_PRODUCT_ID = "SELECT file_id FROM product_image WHERE product_id=:product_id AND type=2";
}
