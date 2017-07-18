package kr.or.reservation.sql;

public class ImgSqls {
	public final static String SELECTBYPRODUCT_ID= "select t1.product_id,file.id as file_id ,file.save_file_name,t1.type from file , (select file_id , product_image.type,product_id from product_image where product_id = :id) t1 \r\n" + 
			"where t1.file_id = file.id order by  t1.type asc ;";
	
	public final static String SELECTBYFILE_ID = "SELECT * FROM file where id = :id;";
}
