package dunkirk.reservation.sql;

public class FileSqls {
	public final static String GET_SAVE_FILE_NAME = 
			"SELECT save_file_name FROM file WHERE id = :id";
	
	public final static String GET_PRODUCT_IMAGE_LIST = 
			"SELECT file_id"
			+ " FROM product_image"
			+ " WHERE product_id = :id AND (type = 1 OR type = 2)";
	
	public final static String GET_PRODUCT_NOTICE_IMAGE_LIST = 
			"SELECT file_id"
			+ " FROM product_image"
			+ " WHERE product_id = :id AND type = 3";
	
	public final static String GET_PRODUCT_INFORMATION_IMAGE = 
			"SELECT file_id"
			+ " FROM product_image"
			+ " WHERE product_id = :id AND type = 4";
}
