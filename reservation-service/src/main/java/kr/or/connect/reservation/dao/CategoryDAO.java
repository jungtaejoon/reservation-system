package kr.or.connect.reservation.dao;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.domain.Category;

import kr.or.connect.reservation.domain.Product;


@Repository
public class CategoryDAO {
	
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<Category> rowMapper = BeanPropertyRowMapper.newInstance(Category.class);
	
	public CategoryDAO(DataSource dataSource) {
		jdbc = new NamedParameterJdbcTemplate(dataSource);
		insertAction = new SimpleJdbcInsert(dataSource)
				.withTableName("category")
				.usingGeneratedKeyColumns("id");
	}
	
	public List<Category> selectCategoriesAll() {
		try {
			return jdbc.query(CategorySqls.SELLECT_ALL, rowMapper);
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
	}

	public Long insertCategory(Category category) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(category);
		return insertAction.executeAndReturnKey(params).longValue();
	}

	public void deleteCategory(int id) {
		Map<String, Integer> params = Collections.singletonMap("id", id);
		jdbc.update(CategorySqls.DELETE_BY_ID, params);
	}

	public void updateCategory(Category category) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(category);
		jdbc.update(CategorySqls.UPDATE_BY_ID, params);
	}



}
