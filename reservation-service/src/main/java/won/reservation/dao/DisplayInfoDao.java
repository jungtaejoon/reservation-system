package won.reservation.dao;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import won.reservation.domain.DisplayInfo;

@Repository
public class DisplayInfoDao {
	
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<DisplayInfo> rowMapper = BeanPropertyRowMapper.newInstance(DisplayInfo.class);
	
	public DisplayInfoDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource)
				.withTableName("display_info")
				.usingGeneratedKeyColumns("id");
	}
	
	public DisplayInfo select(Integer productId) {
		Map<String, Integer> params = new HashMap<>();
		params.put("productid", productId);
		return jdbc.queryForObject(DisplayInfoSqls.SELECT_BY_PRODUCT_ID, params, rowMapper);
	}
}
