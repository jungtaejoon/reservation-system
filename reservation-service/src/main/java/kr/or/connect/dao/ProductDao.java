package kr.or.connect.dao;

import java.util.*;

import javax.sql.*;

import org.springframework.dao.*;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.core.namedparam.*;
import org.springframework.jdbc.core.simple.*;
import org.springframework.stereotype.*;

import kr.or.connect.domain.*;
import kr.or.connect.dto.*;

@Repository
public class ProductDao {
	
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert imageInsertAction;
	private RowMapper<ProductDisplayDto> productDisplayRowMapper = BeanPropertyRowMapper.newInstance(ProductDisplayDto.class);
	private RowMapper<ProductDetailDto> productDetailRowMapper = BeanPropertyRowMapper.newInstance(ProductDetailDto.class);
	private RowMapper<ProductImage> productImageRowMapper = BeanPropertyRowMapper.newInstance(ProductImage.class);
	private RowMapper<ProductPriceDto> productPriceDtoRowMapper = BeanPropertyRowMapper.newInstance(ProductPriceDto.class);

	public ProductDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.imageInsertAction = new SimpleJdbcInsert(dataSource).withTableName("product_image").usingGeneratedKeyColumns("id");
	}
	
	public List<ProductDisplayDto> getSales(Integer start) {
		Map<String, Object> params = new HashMap<>();
		params.put("start", start);
		return jdbc.query(ProductSqls.SELECT_SALE, params, productDisplayRowMapper);
	}
	
	public int countSales() {
		Map<String, Integer> params = Collections.emptyMap();
		try {
			return jdbc.queryForObject(ProductSqls.COUNT_SALE, params, Integer.class);
		} catch (EmptyResultDataAccessException e) {
			return 0;
		}
	}

	public List<ProductDisplayDto> getSalesByCategory(Long categoryId, Integer start) {
		Map<String, Object> params = new HashMap<>();
		params.put("categoryId", categoryId);
		params.put("start", start);
		return jdbc.query(ProductSqls.SELECT_SALE_BY_CATEGORY, params, productDisplayRowMapper);
	}

	public int countSalesByCategory(Long categoryId) {
		Map<String, Long> params = new HashMap<>();
		params.put("categoryId", categoryId);
		try {
			return jdbc.queryForObject(ProductSqls.COUNT_SALE_BY_CATEGORY, params, Integer.class);
		} catch (EmptyResultDataAccessException e) {
			return 0;
		}
	}

	public ProductDetailDto getDetail(Long id) {
		Map<String, Long> params = new HashMap<>();
		params.put("productId", id);
		try {
			return jdbc.queryForObject(ProductSqls.SELECT_PRODUCT_DETAIL, params, productDetailRowMapper);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	public List<ProductImage> getImages(Long id) {
		Map<String, Object> params = new HashMap<>();
		params.put("productId", id);
		return jdbc.query(ProductSqls.SELECT_IMAGES, params, productImageRowMapper);
	}
	
	public ProductImage insertImage(ProductImage productImage) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(productImage);
		productImage.setId(imageInsertAction.executeAndReturnKey(params).longValue());
		return productImage;
	}

	public List<ProductPriceDto> getPrice(Long id) {
		Map<String, Object> params = new HashMap<>();
		params.put("productId", id);
		return jdbc.query(ProductSqls.SELECT_PRICE_BY_ID, params, productPriceDtoRowMapper);
	}

}
