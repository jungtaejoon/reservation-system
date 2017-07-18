package kr.or.connect.reservation.dao;

public class UserCommentSqls {
	final static String GET_ALL = "select t1.id, score, comment, t1.create_date, t1.modify_date, name, user_id, nickname from reservation_user_comment t1" + 
			" inner join product t2 on t1.product_id = t2.id" + 
			" inner join users t3 on t1.user_id = t3.id" + 
			" where t2.id = :productId limit 3";
	
	final static String GET_IMAGES = "select t1.id, save_file_name, file_length from reservation_user_comment_image t1" + 
			" inner join file t2 on t1.file_id = t2.id " + 
			" where reservation_user_comment_id = :id" ;
}
