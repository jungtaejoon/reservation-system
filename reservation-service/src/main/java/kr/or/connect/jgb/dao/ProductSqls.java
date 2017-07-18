package kr.or.connect.jgb.dao;

public class ProductSqls {
	final static String SELECT_ALL = "select name,place_name,event from product p,display_info d where p.id = d.product_id limit :limit offset :offset";
	final static String SELECT_ALL_BY_CATEGORY = "select name,place_name,event from product p,display_info d where p.id = d.product_id and p.category_id = :category_id limit :limit offset :offset";
	//final static String SELECT_ALL = "select * from product limit :limit offset :offset";
	//final static String SELECT_ALL_BY_CATEGORY = "select * from product where category_id = :category_id limit :limit offset :offset";
    final static String SELECT_BY_ID = "select id, name from product where id = :id";
    final static String UPDATE_BY_ID = "update product set name = :name where id = :id";
    final static String DELETE_BY_ID = "delete from product where id = :id";
}
