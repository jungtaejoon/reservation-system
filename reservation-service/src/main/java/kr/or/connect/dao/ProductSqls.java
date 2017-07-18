package kr.or.connect.dao;

public class ProductSqls {
    final static String SELECT_BY_ID = "select id, category_id, name, description, sales_start, sales_end, sales_flag, event, create_date, modify_date from product where id = :id";
    final static String UPDATE_BY_ID = "update product set product = :product , completed = :completed where id = :id";
    final static String DELETE_BY_ID = "delete from product where id = :id";
    final static String SELECT = "select id, category_id, name, description, sales_start, sales_end, sales_flag, event, create_date, modify_date from product where sales_flag = 1 order by id limit 10";
    final static String COUNT_SALE = "select count(*) from product where sales_flag = 1";
    final static String COUNT_SALE_BY_CATEGORY = "select count(*) from product where sales_flag = 1 and category_id = :categoryId";
    
    
    final static String SELECT_FOR_DISPLAY = "select p.id, p.category_id, p.name, p.description, d.place_name from product p left outer join display_info d on p.id = d.product_id where p.sales_flag = 1 order by p.id limit :firstIndex, 10";
	public static final String SELECT_BY_CATEGORY = "select p.id, p.category_id, p.name, p.description, d.place_name from product p left outer join display_info d on p.id = d.product_id where p.sales_flag = 1 and p.category_id = :categoryId order by p.id limit :firstIndex, 10";
}
