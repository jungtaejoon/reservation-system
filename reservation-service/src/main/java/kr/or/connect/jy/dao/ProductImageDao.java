package kr.or.connect.jy.dao;

import java.util.Collection;
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

import kr.or.connect.jy.dto.ProductImage;
import kr.or.connect.jy.dto.ProductImageDTO;

@Repository
public class ProductImageDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<ProductImage> rowMapper = BeanPropertyRowMapper.newInstance(ProductImage.class);
	private RowMapper<ProductImageDTO> dtoRowMapper = BeanPropertyRowMapper.newInstance(ProductImageDTO.class);

	public ProductImageDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource).withTableName("PRODUCT_IMAGE")
				.usingGeneratedKeyColumns("id");
	}

	public Collection<ProductImage> selectAll() {
		return jdbc.query(ProductImageSqls.SELECT_ALL, rowMapper);
	}

	public Collection<ProductImage> selectByProductId(int productId) {
		Map<String, Object> params = new HashMap<>();
		params.put("product_id", productId);
		return jdbc.query(ProductImageSqls.SELECT_BY_PRODUCT_ID, params, rowMapper);
	}

	public int insert(ProductImage productImage) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(productImage);
		return insertAction.executeAndReturnKey(params).intValue();
	}
	
	public List<ProductImageDTO> selectByProductIdForDetail(int productId){
		Map<String, Object> params = new HashMap<>();
		params.put("product_id", productId);
		return jdbc.query(ProductImageSqls.SELECT_BY_PRODUCT_ID_FOR_DETAIL, params, dtoRowMapper);
	}

}
