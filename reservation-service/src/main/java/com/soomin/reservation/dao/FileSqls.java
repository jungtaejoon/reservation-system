package com.soomin.reservation.dao;

public class FileSqls {
	final static String SELECT_BY_FILE_ID = "SELECT file_name, save_file_name, file_length FROM file WHERE id=:id";
}
