package kr.or.connect.reservation.dao;

public class CategorySqls {
	final static String SELECT_BY_ID = "SELECT * FROM category WHERE id = :id";
	final static String UPDATE_BY_ID = "UPDATE category SET name = :name WHERE id = :id";
	final static String DELETE_BY_ID = "DELETE FROM category WHERE id = :id";
	final static String SELECT_ALL = "SELECT * FROM category";
}
