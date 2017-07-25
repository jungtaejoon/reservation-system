package kr.or.connect.jy.dao;

public class DisplayInfoSqls {
	final static String SELECT_BY_PRODUCT_ID = "select di.id, "
			+ "di.observation_time, "
			+ "di.display_start, "
			+ "di.display_end, "
			+ "di.place_name, "
			+ "di.place_lot, "
			+ "di.place_street, "
			+ "di.tel, "
			+ "di.homepage, "
			+ "di.email, "
			+ "di.create_date, "
			+ "di.modify_date "
			+ "from display_info di "
			+ "right outer join product_image pi on pi.product_id=di.product_id "
			+ "where di.product_id = :product_id";
}
