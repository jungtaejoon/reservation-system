package kr.or.connect.jy.dao;

public class ProductDetailSqls {
	final static String SELECT_BY_PRODUCT_ID = 
			"select p.id, pd.content, p.create_date, p.modify_date, p.product_id, p.category_id "
			+ "from product p "
			+ "join product_detail pd on p.id=pd.product_id "
			+ "where p.id = :product_id";
}
