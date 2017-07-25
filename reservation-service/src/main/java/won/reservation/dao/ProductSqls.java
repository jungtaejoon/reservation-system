package won.reservation.dao;

public class ProductSqls {
	static final String SELECT_ALL = "select * from product";
	static final String SELECT_DETAIL_BY_PRODUCT_ID = "select p.id product_id, p.name product_name, p.description description, d.content content, p.event event, s.sales sales " + 
										"from product p, product_detail d, (select if(sales_end >= now(), if(sales_flag = 1, '판매가능', '매진'), '판매기간종료') sales from product where id = :productid) s " + 
										"where p.id = d.product_id and p.id = :productid";
	static final String SELECT_BY_CATEGORYID = "select * from product where category_id = :categoryid";
	static final String COUNT_ALL = "select count(*) cnt from product";
	static final String COUNT_BY_CATEGORYID = "select count(*) from product where category_id = :categoryid";
	static final String UPDATE_BY_ID = "update product set name = :name, description = :description, sales_start = :sales_start, "
										+ "sales_end = :sales_end, sales_flag = :sales_flag, event = :event,  modify_date = now() where id = :id";
	static final String DELETE_BY_ID = "delete from product where id = :id";
	
	static final String SELECT_INFO_ALL = "select product_id, product_name, description, file_name, file_id, place_name " + 
			"from( select pr.id product_id, pr.name product_name, pr.description description, pr.file_name file_name, pr.id file_id, d.place_name place_name " + 
			"from (select p.id id , p.name name , p.description description, f.file_name file_name, f.id file_id " + 
			"from product p, product_image pi, file f " + 
			"where pi.product_id = p.id and f.id = file_id and pi.type = 1) pr, display_info d " + 
			"where pr.id = d.product_id) p " + 
			"limit :displaynum offset :start";
	
	static final String SELECT_INFO_CATEGORY = "select product_id, product_name, description, file_name, file_id, place_name " + 
			"from (select pr.id product_id, pr.name product_name, pr.description description, pr.file_name file_name, pr.id file_id, d.place_name place_name " + 
			"from (select p.id id , p.name name , p.description description, f.file_name file_name, f.id file_id " + 
			"from product p, product_image pi, file f " + 
			"where pi.product_id = p.id and f.id = file_id and pi.type = 1 and p.category_id = :categoryid) pr, display_info d " + 
			"where pr.id = d.product_id) p " + 
			"limit :displaynum offset :start";
}
