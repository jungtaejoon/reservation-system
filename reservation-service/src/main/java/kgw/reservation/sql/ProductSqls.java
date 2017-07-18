package kgw.reservation.sql;
public class ProductSqls {
	private final static String onSale = "1";
	public final static String SELECT_ALL_LIMIT ="select distinct p.id, p.name, p.description, p.sales_end, f.save_file_name, d_i.place_name"
			+ "									 from product p"
			+ "									 inner join display_info d_i  on p.id = d_i.product_id"
			+ "									 left outer join product_image p_i on p.id = p_i.product_id"
			+ "									 left outer join file f on p_i.file_id = f.id"
			+ " 									 where p.sales_flag ="+onSale
			+ "									 order by sales_end asc limit :offset, :size";
	
	public final static String COUNT_ALL = "select count(id) "
			+ "								from product p"
			+ "							   where p.sales_flag ="+onSale;
	
	public final static String SELECT_BY_CATEGORY_LIMIT = "select distinct p.id, p.name, p.description, p.sales_end, f.save_file_name, d_i.place_name"
			+ "												from product p"
			+ "												inner join display_info d_i  on p.id = d_i.product_id"
			+ "												left outer join product_image p_i on p.id = p_i.product_id"
			+ "												left outer join file f on p_i.file_id = f.id"
			+ "												where p.sales_flag = "+onSale+" and category_id = :categoryId"
			+ "												order by sales_end asc limit :offset, :size";

	
	public final static String COUNT_BY_CATEGORY = "select count(id) "
			+ "									   from product p"
			+ "									   where p.sales_flag ="+onSale+" and p.category_id = :categoryId";
	
	public final static String SELECT_BY_ID = "select p.id, p.category_id as categoryId, p.name, p.description, p.sales_start, p.sales_end, p.sales_flag, p.event, p.create_date, p.modify_date, p_i.id as productImageId, p_i.type, p_d.id as productDetailId, p_d.content, p_d.create_date as productDetailCreateDate, p_d.modify_date as productDetailModifyDate, f.id as fileId, f. user_id as userId, f.file_name as fileName, f.save_file_name as saveFileName, f.file_length as fileLength, f.content_type as contentType, f.delete_flag as deleteFlag, f.create_date as fileCreateDate, f.modify_date as fileModifyDate, d_i.id as displayId, d_i.observation_time as observationTime, d_i.display_start as displayStart, d_i.display_end as displayEnd, d_i.place_name as placeName, d_i.place_street as placeStreet, d_i.tel, d_i.homepage, d_i.email, d_i.create_date as displayInfoCreateDate, d_i.modify_date as displayInfoModifyDate, p_p.id as productPriceId, p_p.price_type as priceType, p_p.price, p_p.discount_rate as discountRate, p_p.create_date as productPriceCreateDate, p_p.modify_date as productPriceModifyDate"
			+ "								  from product p, product_image p_i, display_info d_i, file f, product_detail p_d, product_price p_p "
			+ "								  where p.id = :id and p.id = p_i.product_id and p.id = d_i.product_id and p.id = p_d.product_id and p_i.file_id = f.id and p.id = p_p.product_id"
			+ "								  order by p_i.type";
}
