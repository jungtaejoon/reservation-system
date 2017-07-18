package kr.or.connect.dao;

public class CategorySqls {
    final static String SELECT_BY_ID = "select id, name from category where id = :id";
    final static String UPDATE_BY_ID = "update category set category = :category , completed = :completed where id = :id";
    final static String DELETE_BY_ID = "delete from category where id = :id";
    final static String SELECT = "select id, name from category order by id";
}
