package com.juhyung.reservation.persistence;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.juhyung.reservation.domain.CategoryVO;

@Repository
public class CategoryDAOImpl implements CategoryDAO{
	
	private NamedParameterJdbcTemplate jdbc; 
    private SimpleJdbcInsert insertAction; 
    private RowMapper<CategoryVO> rowMapper = BeanPropertyRowMapper.newInstance(CategoryVO.class); 
    
    public CategoryDAOImpl(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource); 
        this.insertAction = new SimpleJdbcInsert(dataSource) 
                .withTableName("category")   
                .usingGeneratedKeyColumns("id"); 
    }

	@Override
	public List<CategoryVO> selectListAll() {
		return jdbc.query(CategorySqls.SELECT_LIST_ALL, rowMapper);
	}

	@Override
	public int insert(CategoryVO category) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(category);
        return insertAction.executeAndReturnKey(params).intValue();
    }

	@Override
	public int deleteById(Integer id) {
		Map<String, ?> params = Collections.singletonMap("id", id);
    	return jdbc.update(CategorySqls.DELETE_BY_ID, params);		
	}

	@Override
	public CategoryVO selectById(Integer id) {
		Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        return jdbc.queryForObject(CategorySqls.SELECT_BY_ID, params, rowMapper);
	}

	@Override
	public int updateById(CategoryVO category) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(category);
		return jdbc.update(CategorySqls.UPDATE_BY_ID, params);
	}
	
}
