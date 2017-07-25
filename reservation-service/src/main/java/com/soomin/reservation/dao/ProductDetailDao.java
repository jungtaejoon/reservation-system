package com.soomin.reservation.dao;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.soomin.reservation.domain.ProductDetail;

@Repository
public class ProductDetailDao {
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<ProductDetail> rowMapper = BeanPropertyRowMapper.newInstance(ProductDetail.class);
	
	public ProductDetailDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}

	public List<ProductDetail> SelectProductDetailById(Long id){
		Map<String, Object> params = Collections.singletonMap("id", id);
		return jdbc.query(ProductDetailSqls.SELECT_DETAIL_BY_PRODUCT_ID, params, rowMapper);
	}
}
