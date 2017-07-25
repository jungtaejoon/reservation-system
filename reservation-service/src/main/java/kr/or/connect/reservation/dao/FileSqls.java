package kr.or.connect.reservation.dao;

public class FileSqls {
	final static String SELECT_BY_ID = 
			"SELECT"
			+ " id, file_name, save_file_name, file_length, content_type, delete_flag"
			+ " FROM file "
			+ " WHERE id = :id";
}
