package kr.or.connect.jgb.dao;

public class CategorySqls {
	final static String SELECT_ALL = "select * from category";
    final static String SELECT_BY_ID = "select id, name from category where id = :id";
    final static String UPDATE_BY_ID = "update category set name = :name where id = :id";
    final static String DELETE_BY_ID = "delete from category where id = :id";
}