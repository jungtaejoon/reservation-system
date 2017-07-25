package kr.or.connect.jy.dao;

public class ProductDTOSqls {
    final static String SELECT_ALL_LIMIT4 = "select product.id, product.name, " + 
    		"display_info.place_name, product_detail.content, product.category_id, product_image.file_id " + 
    		"from product " + 
    		"join display_info on display_info.product_id=product.id " + 
    		"join product_detail on product_detail.product_id=product.id " + 
    		"join product_image on product_image.product_id=product.id " + 
    		"GROUP BY product.id " + 
    		"LIMIT 4";
    
    final static String SELECT_ALL_FROM_LAST_LIMIT10 = "select product.id, product.name, " + 
    		"product.category_id, display_info.place_name, product_detail.content, product_image.file_id " + 
    		"from product " + 
    		"join display_info on display_info.product_id=product.id " + 
    		"join product_detail on product_detail.product_id=product.id " + 
    		"join product_image on product_image.product_id=product.id " + 
    		"where product.id > :id " + 
    		"GROUP BY product.id " + 
    		"LIMIT 10";
    
    final static String SELECT_BY_CATEGORY_ID_LIMIT4 = "select product.id, product.name, " + 
    		"product.category_id, display_info.place_name, product_detail.content, product_image.file_id " + 
    		"from product " + 
    		"join display_info on display_info.product_id=product.id " + 
    		"join product_detail on product_detail.product_id=product.id " + 
    		"join product_image on product_image.product_id=product.id " + 
    		"where product.category_id = :category_id " + 
    		"GROUP BY product.id " + 
    		"LIMIT 4";
    
    final static String SELECT_BY_CATEGORY_ID_LIMIT10 = "select product.id, product.name, " + 
    		"product.category_id, display_info.place_name, product_detail.content, product_image.file_id " + 
    		"from product " + 
    		"join display_info on display_info.product_id=product.id " + 
    		"join product_detail on product_detail.product_id=product.id " + 
    		"join product_image on product_image.product_id=product.id " + 
    		"where product.category_id = :category_id " + 
    		"GROUP BY product.id " + 
    		"LIMIT 10";
    
    final static String SELECT_BY_CATEGORY_ID_FROM_LAST_LIMIT10 = "select product.id, product.name, " + 
    		"product.category_id, display_info.place_name, product_detail.content, product_image.file_id " + 
    		"from product " + 
    		"join display_info on display_info.product_id=product.id " + 
    		"join product_detail on product_detail.product_id=product.id " + 
    		"join product_image on product_image.product_id=product.id " + 
    		"where product.category_id = :category_id " + 
    		"AND product.id > :id " + 
    		"GROUP BY product.id " + 
    		"LIMIT 10";
    
    final static String SELECT_BY_PRODUCT_ID = "select p.id, p.name, "
    		+ "p.event, di.place_name, pd.content, "
    		+ "p.sales_start, p.sales_end, p.sales_flag, p.category_id "
    		+ "from product p "
    		+ "join display_info di on di.product_id=p.id "
    		+ "join product_detail pd on pd.product_id=p.id "
    		+ "where p.id = :product_id";
}
