package kr.or.connect.jy.dao;

public class ProductSqls {
    final static String SELECT_ALL = "select id, category_id, name, description, "
    		+ "sales_start, sales_end, sales_flag, "
    		+ "event, create_date, modify_date "
    		+ "from product";
    
    final static String SELECT_ALL_LIMIT4 = "select id, category_id, name, description, "
    		+ "sales_start, sales_end, sales_flag, "
    		+ "event, create_date, modify_date "
    		+ "from product "
    		+ "LIMIT 4";
    
    final static String SELECT_ALL_FROM_LAST_LIMIT10 = "select id, category_id, name, description, "
    		+ "sales_start, sales_end, sales_flag, "
    		+ "event, create_date, modify_date "
    		+ "from product "
    		+ "where id > :id "
    		+ "LIMIT 10";
    
    final static String SELECT_BY_CATEGORY_ID_LIMIT4 = "select id, category_id, name, description, "
    		+ "sales_start, sales_end, sales_flag, "
    		+ "event, create_date, modify_date "
    		+ "from product "
    		+ "where category_id = :category_id "
    		+ "LIMIT 4";
    
    final static String SELECT_BY_CATEGORY_ID_LIMIT10 = "select id, category_id, name, description, "
    		+ "sales_start, sales_end, sales_flag, "
    		+ "event, create_date, modify_date "
    		+ "from product "
    		+ "where category_id = :category_id "
    		+ "LIMIT 10";
    
    final static String SELECT_BY_CATEGORY_ID_FROM_LAST = "select id, category_id, name, description, "
    		+ "sales_start, sales_end, sales_flag, "
    		+ "event, create_date, modify_date "
    		+ "from product "
    		+ "where category_id = :category_id "
    		+ "AND id > :id "
    		+ "LIMIT 10";
    
    final static String SELECT_BY_ID = "select * from product where id=:id";
    final static String COUNT_ALL = "select count(id) from product";
    final static String COUNT_BY_CATEGORY_ID = "select count(id) from product where category_id = :category_id";
}
