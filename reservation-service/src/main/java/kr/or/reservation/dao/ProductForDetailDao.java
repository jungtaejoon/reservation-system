package kr.or.reservation.dao;

import java.util.Collections;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.reservation.domain.Product;
import kr.or.reservation.domain.ProductForDetail;
import kr.or.reservation.sql.ProductForDetailSqls;

@Repository
public class ProductForDetailDao {
	
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<ProductForDetail> rowMapper = BeanPropertyRowMapper.newInstance(ProductForDetail.class);

	public ProductForDetailDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public ProductForDetail selectOne(int id) {
		Map<String , ?> params = Collections.singletonMap("id", id);
		return jdbc.queryForObject(ProductForDetailSqls.SELECT_DETAIL,params, rowMapper);
	}
	
	
}
