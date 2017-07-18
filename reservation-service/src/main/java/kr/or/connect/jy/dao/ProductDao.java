package kr.or.connect.jy.dao;

import java.util.Collection;
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

import kr.or.connect.jy.dto.Product;
import kr.or.connect.jy.dto.ProductDTO;

@Repository
public class ProductDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<ProductDTO> rowMapper = BeanPropertyRowMapper.newInstance(ProductDTO.class);

	public ProductDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource).withTableName("ProductSummaryDTO")
				.usingGeneratedKeyColumns("id");
	}
	
	public Collection<ProductDTO> selectAll() {
		return jdbc.query(ProductDTOSqls.SELECT_ALL_LIMIT4, rowMapper);
	}
	
	public Collection<ProductDTO> selectByCategoryId(int categoryId) {
		Map<String, Object> params = new HashMap<>();
		params.put("category_id", categoryId);
		return jdbc.query(ProductDTOSqls.SELECT_BY_CATEGORY_ID_LIMIT4, params, rowMapper);
	}

	public Integer countAll() {
		Map<String, Object> params = Collections.emptyMap();
		return jdbc.queryForObject(ProductSqls.COUNT_ALL, params, Integer.class);
	}

	public Integer countByCategoryId(Integer categoryId) {
		Map<String, Object> params = new HashMap<>();
		params.put("category_id", categoryId);
		return jdbc.queryForObject(ProductSqls.COUNT_BY_CATEGORY_ID, params, Integer.class);
	}

	public Collection<ProductDTO> selectByCategoryIdFromLast(Integer categoryId, Integer lastProductId) {
		Map<String, Object> params = new HashMap<>();
		params.put("category_id", categoryId);
		params.put("id", lastProductId);
		return jdbc.query(ProductDTOSqls.SELECT_BY_CATEGORY_ID_FROM_LAST_LIMIT10, params, rowMapper);
	}

	public Collection<ProductDTO> selectFromLast(Integer lastProductId) {
		Map<String, Object> params = new HashMap<>();
		params.put("id", lastProductId);
		return jdbc.query(ProductDTOSqls.SELECT_ALL_FROM_LAST_LIMIT10, params, rowMapper);
	}
}
