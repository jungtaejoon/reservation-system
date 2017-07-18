package kr.or.connect.reservation.dao;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.domain.ProductForMain;

@Repository
public class ProductForMainDao {
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<ProductForMain> rowMapper = BeanPropertyRowMapper.newInstance(ProductForMain.class);
	
	public ProductForMainDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<ProductForMain> getAll(Integer start, Integer count) {
		Map<String, Object> params = new HashMap<>();
		params.put("start", start);
		params.put("count", count);
		return jdbc.query(ProductForMainSqls.SELECT_ALL, params, rowMapper);
	}

	public List<ProductForMain> getByCategory(Integer categoryId, Integer start, Integer count) {
		Map<String, Object> params = new HashMap<>();
		params.put("categoryId", categoryId);
		params.put("start", start);
		params.put("count", count);
		return jdbc.query(ProductForMainSqls.SELECT_BY_CATEGORY, params, rowMapper);
	}
	
	public Integer countAll() {
		Map<String, ?> params = Collections.emptyMap();
		return jdbc.queryForObject(ProductForMainSqls.COUNT_ALL, params, Integer.class);
	}
	
	public Integer countByCategory(Integer categoryId) {
		Map<String, Object> params = new HashMap<>();
		params.put("categoryId", categoryId);
		return jdbc.queryForObject(ProductForMainSqls.COUNT_BY_CATEGORY, params, Integer.class);
	}
	
	public List<ProductForMain> getVisual() {
		return jdbc.query(ProductForMainSqls.SELECT_VISUAL, rowMapper);
	}
	
}
