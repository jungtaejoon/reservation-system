package kr.or.connect.dao;

public class CategorySqls {
    final static String SELECT_BY_ID = "select * from category where id = :id";
    final static String UPDATE_BY_ID = "update category set category = :category , completed = :completed where id = :id";
    final static String DELETE_BY_ID = "delete from category where id = :id";
    final static String SELECT = "select * from category order by id desc limit :start, :count";
}
