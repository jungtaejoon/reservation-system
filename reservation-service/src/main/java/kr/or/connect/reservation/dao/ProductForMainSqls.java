package kr.or.connect.reservation.dao;

public class ProductForMainSqls {
	final static String SELECT_ALL = "select t1.id, category_id, name, description, place_name, save_file_name, file_length "
			+ " from PRODUCT t1 INNER JOIN PRODUCT_IMAGE t2 on t1.id = t2.product_id"
			+ " LEFT OUTER JOIN DISPLAY_INFO t4 ON t1.id = t4.product_id" 
			+ " INNER JOIN FILE t5 ON t2.file_id = t5.id where sales_flag=0 and type = 1 limit :start, :count";
	
	final static String SELECT_BY_CATEGORY = "select t1.id, category_id, name, description, place_name, save_file_name, file_length "
			+ " from PRODUCT t1 INNER JOIN PRODUCT_IMAGE t2 on t1.id = t2.product_id"
			+ " LEFT OUTER JOIN DISPLAY_INFO t4 ON t1.id = t4.product_id"
			+ " INNER JOIN FILE t5 ON t2.file_id = t5.id where category_id= :categoryId and sales_flag=0 and type = 1 limit :start, :count";
	
	final static String COUNT_ALL = "select count(*) from product where sales_flag=0";
	
	final static String COUNT_BY_CATEGORY = "select count(*) from product where category_id = :categoryId and sales_flag=0";
	
	final static String SELECT_VISUAL = "select t1.id, category_id, name, description, place_name, save_file_name, file_length "
			+ " from PRODUCT t1 INNER JOIN PRODUCT_IMAGE t2 on t1.id = t2.product_id"
			+ " LEFT OUTER JOIN DISPLAY_INFO t4 ON t1.id = t4.product_id" 
			+ " INNER JOIN FILE t5 ON t2.file_id = t5.id where sales_flag=0 and type = 3";
}
