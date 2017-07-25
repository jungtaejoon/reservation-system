package com.soomin.reservation.dao;

public class DisplayInfoSqls {
	final static String SELECT_INFO_BY_PRODUCT_ID = "SELECT homepage, tel, email, place_street FROM display_info WHERE product_id=:id";
}
