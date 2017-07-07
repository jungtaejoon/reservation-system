package kr.or.connect.dao;

import java.util.*;

import javax.sql.*;

import org.springframework.jdbc.core.*;
import org.springframework.jdbc.core.namedparam.*;
import org.springframework.jdbc.core.simple.*;
import org.springframework.stereotype.*;

import kr.or.connect.domain.*;

@Repository
public class CategoryDao {

	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<Category> rowMapper = BeanPropertyRowMapper.newInstance(Category.class);

	public CategoryDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource).withTableName("category").usingGeneratedKeyColumns("id");
	}
	
	public Category insert(Category category) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(category);
		category.setId(insertAction.executeAndReturnKey(params).longValue());
		return category;
	}

	public List<Category> getAll() {
		return jdbc.query(CategorySqls.SELECT, rowMapper);
	}

	public Category selectById(Long id) {
		Map<String, Object> params = new HashMap<>();
		params.put("id", id);
		return jdbc.queryForObject(CategorySqls.SELECT_BY_ID, params, rowMapper);
	}
	
	public int delete(long id) {
		Map<String, ?> params = Collections.singletonMap("id", id);
		return jdbc.update(CategorySqls.DELETE_BY_ID, params);
	}
}
