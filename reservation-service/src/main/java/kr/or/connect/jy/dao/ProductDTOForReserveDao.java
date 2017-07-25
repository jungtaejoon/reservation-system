package kr.or.connect.jy.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.connect.jy.dto.ProductDTOForReserve;

@Repository
public class ProductDTOForReserveDao {
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<ProductDTOForReserve> rowMapper = BeanPropertyRowMapper.newInstance(ProductDTOForReserve.class);

	public ProductDTOForReserveDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public ProductDTOForReserve selectByProductId(int productId) {
		Map<String, Object> params = new HashMap<>();
		params.put("product_id", productId);
		
		return jdbc.queryForObject(ProductDTOForReserveSqls.SELECT_BY_PRODUCT_ID, params, rowMapper);
	}

}
