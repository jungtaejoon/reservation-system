package kr.or.reservation.dao;

public class CategorySqls {
	// Query문을 별도의 class로 저장
	final static String SELECT_BY_ID = "select * from category where id = :id";
	final static String UPDATE_BY_ID = "update category set name = :name where id = :id";
	final static String DELETE_BY_ID = "delete from category where id = :id";
	final static String SELECT_ALL = "select * from category";
}
