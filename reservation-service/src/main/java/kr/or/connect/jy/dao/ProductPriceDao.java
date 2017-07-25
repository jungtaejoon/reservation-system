package kr.or.connect.jy.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.or.connect.jy.dto.ProductPrice;

@Repository
public class ProductPriceDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<ProductPrice> rowMapper = BeanPropertyRowMapper.newInstance(ProductPrice.class);

	public ProductPriceDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource).withTableName("PRODUCT_PRICE")
				.usingGeneratedKeyColumns("id");
	}

	public List<ProductPrice> selectByProductId(Integer productId) {
		Map<String, Object> params = new HashMap<>();
		params.put("product_id", productId);
		
		return jdbc.query("select pp.id as priceId, pp.price_type, pp.price, pp.discount_rate " + 
				"from product_price pp " + 
				"where product_id = :product_id", params, rowMapper);
	}
}
