package dunkirk.reservation.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import dunkirk.reservation.domain.Category;
import dunkirk.reservation.dao.CategoryDao;

@Repository
public class CategoryDaoImpl implements CategoryDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<Category> rowMapper = new BeanPropertyRowMapper(Category.class);
	
	public List<Category> getList() {
		// TODO Auto-generated method stub
		return null;
	}

}
