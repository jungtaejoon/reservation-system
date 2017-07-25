package com.soomin.reservation.dao;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.soomin.reservation.domain.Product;

@Repository
public class ProductDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<Product> rowMapper = BeanPropertyRowMapper.newInstance(Product.class);
	
	public ProductDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource)
				.withTableName("product")
				.usingGeneratedKeyColumns("id");
	}
	
	public List<Product> SelectPromotion() {
		return jdbc.query(ProductSqls.SELECT_PROMOTION, rowMapper);
	}
	
	public Long CountAll() {
		Map<String, Object> params = Collections.emptyMap();
		
		return jdbc.queryForObject(ProductSqls.COUNT_PRODUCT_ALL, params, Long.class);
	}
	public Long CountByCategory(Long categoryId) {
		Map<String, ?> params = Collections.singletonMap("category_id", categoryId);
		return jdbc.queryForObject(ProductSqls.COUNT_PRODUCT_BY_CATEGORY, params, Long.class);
	}
	
	public List<Product> SelectProductAll(Long offset){
		Map<String, ?> params = Collections.singletonMap("offset", offset);
		return jdbc.query(ProductSqls.SELECT_PRODUCT_ALL, params, rowMapper);
	}
	public List<Product> SelectProductByCategoryId(Long categoryId, Long offset){
		Map<String, Object> params = new HashMap<>();
		params.put("category_id", categoryId);
		params.put("offset", offset);
		return jdbc.query(ProductSqls.SELECT_PRODUCT_BY_CATEGORY, params, rowMapper);
	}
	public List<Product> SelectProductById(Long id) {
		Map<String, ?> params = Collections.singletonMap("id", id);
		return jdbc.query(ProductSqls.SELECT_PRODUCT_DETAIL_BY_ID, params, rowMapper);
	}
	
}
