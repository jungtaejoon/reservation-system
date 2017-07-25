package won.reservation.dao;

public class FileSqls {
	static final String SELECT_BY_PRODUCT_ID = "select f.*" + 
			"from product p, product_image pi, file f " + 
			"where pi.product_id = p.id and f.id = pi.file_id and f.content_type='상품타이틀' and pi.product_id = :productid " + 
			"order by pi.type asc";
	
	static final String SELECT_COMMENT_BY_PRODUCT_ID = "select f.* " + 
			"from reservation_user_comment_image i, file f " + 
			"where i.file_id = f.id and f.content_type='한줄평' and reservation_user_comment_id = :commentid";
	
	static final String SELECT_DETAIL_BY_PRODUCT_ID = "select f.* " + 
			"from product p, product_image i, file f " + 
			"where p.id = i.product_id and f.id = i.file_id and i.type=2 and f.content_type='상품상세' and p.id=:productid";

	static final String SELECT_BY_ID = "select save_file_name from file where id = :fileid";
}
