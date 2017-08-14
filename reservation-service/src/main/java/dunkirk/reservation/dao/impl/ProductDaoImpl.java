package dunkirk.reservation.dao.impl;

import java.util.*;

import javax.sql.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.core.namedparam.*;
import org.springframework.stereotype.*;

import dunkirk.reservation.dao.*;
import dunkirk.reservation.dto.*;
import dunkirk.reservation.sql.*;

@Repository
public class ProductDaoImpl implements ProductDao {

	private NamedParameterJdbcTemplate jdbc;

	@Autowired
	public ProductDaoImpl(DataSource dataSource) {
		super();
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public List<ProductForMainDto> getList(int categoryId, int page) {
		RowMapper<ProductForMainDto> rowMapper = new BeanPropertyRowMapper<>(ProductForMainDto.class);
		Map<String, Integer> params = new HashMap<>();
		params.put("page", page);
		if (categoryId == 0) {
			return jdbc.query(ProductSqls.GET_LIST, params, rowMapper);
		} else {
			params.put("category_id", categoryId);
			return jdbc.query(ProductSqls.GET_LIST_BY_CATEGORY, params, rowMapper);
		}
	}

	@Override
	public ProductForDetailDto getDetail(int id) {
		RowMapper<ProductForDetailDto> rowMapper = new BeanPropertyRowMapper<>(ProductForDetailDto.class);
		Map<String, Integer> params = new HashMap<>();
		params.put("id", id);
		return jdbc.queryForObject(ProductSqls.GET_DETAIL, params, rowMapper);
	}

	@Override
	public ProductForReservationDto getForReservation(int id) {
		RowMapper<ProductForReservationDto> rowMapper = new BeanPropertyRowMapper<>(ProductForReservationDto.class);
		Map<String, Integer> params = new HashMap<>();
		params.put("id", id);
		return jdbc.queryForObject(ProductSqls.GET_FOR_RESERVATION, params, rowMapper);
	}
}
