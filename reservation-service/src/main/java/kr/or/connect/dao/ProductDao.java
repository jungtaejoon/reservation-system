package kr.or.connect.dao;

import java.util.*;

import javax.sql.*;

import org.springframework.jdbc.core.*;
import org.springframework.jdbc.core.namedparam.*;
import org.springframework.jdbc.core.simple.*;
import org.springframework.stereotype.*;

import kr.or.connect.domain.*;
import kr.or.connect.dto.*;

@Repository
public class ProductDao {
	
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<Product> productRowMapper = BeanPropertyRowMapper.newInstance(Product.class);
	private RowMapper<ProductDisplayDto> productDisplayRowMapper = BeanPropertyRowMapper.newInstance(ProductDisplayDto.class);

	public ProductDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource).withTableName("product").usingGeneratedKeyColumns("id");
	}
	
	public List<ProductDisplayDto> getSales(Integer firstIndex) {
		Map<String, Object> params = new HashMap<>();
		params.put("firstIndex", firstIndex);
		return jdbc.query(ProductSqls.SELECT_FOR_DISPLAY, params, productDisplayRowMapper);
	}
	
	public int countSales() {
		Map<String, Integer> params = Collections.emptyMap();
		return jdbc.queryForObject(ProductSqls.COUNT_SALE, params, Integer.class);
	}

	public List<ProductDisplayDto> getSalesByCategory(Long categoryId, Integer firstIndex) {
		Map<String, Object> params = new HashMap<>();
		params.put("categoryId", categoryId);
		params.put("firstIndex", firstIndex);
		return jdbc.query(ProductSqls.SELECT_BY_CATEGORY, params, productDisplayRowMapper);
	}

	public int countSalesByCategory(Long categoryId) {
		Map<String, Long> map = new HashMap<>();
		map.put("categoryId", categoryId);
		return jdbc.queryForObject(ProductSqls.COUNT_SALE_BY_CATEGORY, map, Integer.class);
	}

}
