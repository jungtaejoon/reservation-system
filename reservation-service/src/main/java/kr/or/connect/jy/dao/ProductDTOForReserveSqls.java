package kr.or.connect.jy.dao;

public class ProductDTOForReserveSqls {
	final static String SELECT_BY_PRODUCT_ID = 
			"select p.id as productId, p.name as productName, p.description, "
			+ "p.sales_start, p.sales_end, "
			+ "p.sales_flag, p.event, "
			+ "di.observation_time, di.display_start, "
			+ "di.display_end, di.place_name, "
			+ "di.place_lot, di.place_street, "
			+ "pi.type as productImageType, pi.file_id "
			+ "from product p "
			+ "join display_info di on di.product_id=p.id "
			+ "join product_image pi on pi.product_id=p.id "
			+ "where p.id=:product_id "
			+ "group by pi.product_id";
}
