package dunkirk.reservation.dao.impl;

import java.util.*;

import javax.sql.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.core.namedparam.*;
import org.springframework.stereotype.*;

import dunkirk.reservation.dao.*;
import dunkirk.reservation.sql.*;
import durkirk.reservation.dto.*;

@Repository
public class ProductDaoImpl implements ProductDao {

	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<ProductForMainDto> rowMapper = new BeanPropertyRowMapper<ProductForMainDto>(ProductForMainDto.class);

	@Autowired
	public ProductDaoImpl(DataSource dataSource) {
		super();
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public List<ProductForMainDto> getList(int categoryId, int start) {
		Map<String, Integer> params = new HashMap<>();
		params.put("start", start);
		if(categoryId == 0) {
			return jdbc.query(ProductSqls.GET_LIST, params, rowMapper);
		}else {
			params.put("category_id", categoryId);
			return jdbc.query(ProductSqls.GET_LIST_BY_CATEGORY, params, rowMapper);
		}
	}

}
