package kr.or.connect.reservation.dao;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.domain.Product;
import kr.or.connect.reservation.dto.MainPageProductDto;
import kr.or.connect.reservation.dto.ResponseProductList;

@Repository
public class ProductDao {
	private NamedParameterJdbcTemplate jdbc; // sql 을 실행하기 위해 사용되는 객체
	private SimpleJdbcInsert insertAction; // insert 를 편리하게 하기 위한 객체

	private RowMapper<MainPageProductDto> productMapper = BeanPropertyRowMapper.newInstance(MainPageProductDto.class);
	private RowMapper<ResponseProductList> responseMapper = BeanPropertyRowMapper.newInstance(ResponseProductList.class);

	public ProductDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}

	public Map<String, Object> selectProductsByCategoryId(Long id, int limit, int offset) {
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> dataParams = new HashMap<String, Object>();
		Map<String, ?> counterParams = Collections.singletonMap("category_id", id);
		
		dataParams.put("category_id", id);
		dataParams.put("limit", limit);
		dataParams.put("offset", offset);
		
		List<MainPageProductDto> products = jdbc.query(ProductSqls.SELECT_BY_CATEGORY_ID, dataParams, productMapper);
		Long totalCount = jdbc.queryForObject(ProductSqls.SELECT_TOTAL_COUNT_BY_CATEGORY_ID, counterParams, Long.class);
		
		result.put("totalCount", totalCount);
		result.put("products", products);
		
		if(products == null || products.isEmpty() || totalCount == 0) {
			throw new EmptyResultDataAccessException(1);
		}
		
		return result;
	}
	
	public Map<String, Object> selectAllProduct(int limit, int offset) {
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> dataParams = new HashMap<String, Object>();
		Map<String, Object> emptyParams = new HashMap<String, Object>();
		
		dataParams.put("limit", limit);
		dataParams.put("offset", offset);
		
		List<MainPageProductDto> products = jdbc.query(ProductSqls.SELECT_ALL, dataParams, productMapper);
		Long totalCount = jdbc.queryForObject(ProductSqls.SELECT_TOTAL_COUNT, emptyParams , Long.class);
		
		result.put("totalCount", totalCount);
		result.put("products", products);
		
		if(products == null || products.isEmpty() || totalCount == 0) {
			throw new EmptyResultDataAccessException(1);
		}
		
		return result;
	}
}
