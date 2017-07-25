package kr.or.connect.dao;

public class FileSqls {
	final static String SELECT_BY_ID = "SELECT id, user_id, file_name, save_file_name, file_length, content_type, create_date, modify_date FROM file where delete_flag = 0 and id = :fileId;";
}
