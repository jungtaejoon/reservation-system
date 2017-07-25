package kr.or.connect.reservation.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.domain.Price;

@Repository
public class PriceDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<Price> rowMapper = BeanPropertyRowMapper.newInstance(Price.class);
	
	public PriceDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource)
				.withTableName("prices")
				.usingGeneratedKeyColumns("id");
	}
	
	public List<Price> getByProductId(Integer productId) {
		Map<String, Object> params = new HashMap<>();
		params.put("productId", productId);
		return jdbc.query(PriceSqls.SELECT_BY_PRODUCT_ID, params, rowMapper);
	}
}
