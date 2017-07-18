package kr.or.reservation.sql;

public class ProductForDetailSqls {
	public final static String SELECT_DETAIL = "select product.id, product.name,product.description, product.event ,product.sales_flag, product.sales_end, detail.content , display.homepage,display.email,display.tel , display.place_name,display.place_lot,display.place_street " + 
			"from product left outer join  product_detail detail " + 
			"	on product.id = detail.product_id " + 
			"left outer join display_info  display " + 
			"	on product.id = display.product_id "+ 
			"where product.id = :id ; ";
}
