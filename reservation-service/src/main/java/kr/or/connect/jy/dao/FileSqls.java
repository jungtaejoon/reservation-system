package kr.or.connect.jy.dao;

public class FileSqls {
	// admin ID = 1
	final static String INSERT_FILE = 
			"insert into FILE(user_id, file_name, save_file_name, file_length, content_type, delete_flag, create_date, modify_date)"
			+ " values(1, :file_name, :save_file_name, :file_length, :content_type, :delete_flag, now(), now())";
	
	final static String SELECT_BY_ID = 
			"select id, user_id, file_name, save_file_name, file_length, content_type, delete_flag, create_date, modify_date"
			+ " from FILE where id=:id";
}
