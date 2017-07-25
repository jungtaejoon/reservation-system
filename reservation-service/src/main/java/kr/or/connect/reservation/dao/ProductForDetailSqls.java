package kr.or.connect.reservation.dao;

public class ProductForDetailSqls {
	final static String GET_INFO = "select t1.id, category_id, name, description, sales_start, sales_end, sales_flag, event, t1.create_date, t1.modify_date, content, " + 
			"  observation_time, display_start, display_end, place_name, place_lot, place_street, tel, homepage, email" + 
			", avg_score, comment_count " +
			"  from PRODUCT t1 " + 
			"  LEFT OUTER JOIN PRODUCT_DETAIL t2 ON t1.id = t2.product_id " + 
			"  LEFT OUTER JOIN DISPLAY_INFO t3 ON t1.id = t3.product_id" + 
			"  where t1.id = :id";
	
	final static String GET_IMAGES = "select t2.id, save_file_name, file_length " + 
			"	from PRODUCT t1 INNER JOIN PRODUCT_IMAGE t2 on t1.id = t2.product_id " + 
			"   INNER JOIN FILE t3 ON t2.file_id = t3.id" + 
			"   where t1.id = :id and type <= 2";
	
	final static String GET_MAIN_IMAGE = "select t2.id, save_file_name, file_length " + 
			"	from PRODUCT t1 INNER JOIN PRODUCT_IMAGE t2 on t1.id = t2.product_id " + 
			"   INNER JOIN FILE t3 ON t2.file_id = t3.id" + 
			"   where t1.id = :id and type = 1";
}
