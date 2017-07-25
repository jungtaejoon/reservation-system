package com.soomin.reservation.dao;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.soomin.reservation.domain.ProductImage;

@Repository
public class ProductImageDao {
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<ProductImage> rowMapper = BeanPropertyRowMapper.newInstance(ProductImage.class);
	
	public ProductImageDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<ProductImage> selectRepresentByProductId(long id){
		Map<String, ?> params = Collections.singletonMap("product_id", id);
		return jdbc.query(ProductImageSqls.SELECT_REPRESENT_BY_PRODUCT_ID, params, rowMapper);
	}
	
	public ProductImage selectThumbnailByProductId(long id) {
		Map<String, ?> params = Collections.singletonMap("product_id", id);
		return jdbc.query(ProductImageSqls.SELECT_ONE_BY_PRODUCT_ID, params, rowMapper).get(0);
	}
	
	public List<ProductImage> selectAdditionalByProductId(long id){
		Map<String, ?> params = Collections.singletonMap("product_id", id);
		return jdbc.query(ProductImageSqls.SELECT_ADDITIONAL_BY_PRODUCT_ID, params, rowMapper);
	}

	public int countByProductId(long id) {
		// TODO Auto-generated method stub
		Map<String, ?> params = Collections.singletonMap("product_id", id);
		return jdbc.queryForObject(ProductImageSqls.COUNT_BY_PRODUCT_ID, params, Integer.class);
	}
}
