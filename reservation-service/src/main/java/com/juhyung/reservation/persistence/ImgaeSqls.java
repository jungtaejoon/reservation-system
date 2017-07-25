package com.juhyung.reservation.persistence;

public class ImgaeSqls {
	
	static final String SELECT_IMAGES_BY_PRODUCT_ID = 
			"select file_id from product_image where product_id= :product_id";
	static final String SELECT_MAIN_IMAGE_OF_PRODUCT =
			"select id from product_image where type=1 and product_id= :product_id";
	static final String SELECT_IMAGE_BY_FILE =
			"select * from file where id= :file_id";
	
	
	//comment-file(image)
	static final String SELECT_FILES_BY_COMMENT_ID =
			"select file_id from reservation_user_comment_image where reservation_user_omment_id= :comment_id";
	
}
