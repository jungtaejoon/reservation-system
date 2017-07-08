package kr.or.connect.jy.dao;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.or.connect.jy.dto.Category;

@Repository
public class CategoryDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<Category> rowMapper = BeanPropertyRowMapper.newInstance(Category.class);

	public CategoryDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource).withTableName("category") // table 이름
				.usingGeneratedKeyColumns("id"); // pk
	}

	public Integer insert(Category category) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(category);
		return insertAction.executeAndReturnKey(params).intValue();
	}

	public Category selectById(Integer id) {
		Map<String, Object> params = new HashMap<>();
		params.put("id", id);
		return jdbc.queryForObject(CategorySqls.SELECT_BY_ID, params, rowMapper);
	}

	public Collection<Category> selectAll() {
		Map<String, Object> params = Collections.emptyMap();
		return jdbc.query(CategorySqls.SELECT_ALL, params, rowMapper);
	}

	public int update(Category category) {
        SqlParameterSource params = new BeanPropertySqlParameterSource(category);
        return jdbc.update(CategorySqls.UPDATE_BY_ID, params);
	}
	
    public int delete(Integer id){
        Map<String, ?> params = Collections.singletonMap("id", id); // 싱글톤맵 = 하나짜리 맵
        return jdbc.update(CategorySqls.DELETE_BY_ID, params);
    }
}
