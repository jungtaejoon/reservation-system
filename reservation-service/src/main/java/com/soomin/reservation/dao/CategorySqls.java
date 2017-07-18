package com.soomin.reservation.dao;

public class CategorySqls {
	final static String SELECT_ALL = "SELECT id, name FROM category ORDER BY id";
	final static String SELECT_BY_ID = "SELECT id, name FROM category WHERE id=:id";
	final static String DELETE_BY_ID = "DELETE FROM category where id=:id";
	final static String UPDATE_NAME = "UPDATE category SET name=:name WHERE id=:id";
}
