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
public class CommentDaoImpl implements CommentDao {

	private NamedParameterJdbcTemplate jdbc;

	@Autowired
	public CommentDaoImpl(DataSource dataSource) {
		super();
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public List<CommentForDetailDto> getListByProduct(int page, int limit, int productId) {
		RowMapper<CommentForDetailDto> rowMapper = new BeanPropertyRowMapper<>(CommentForDetailDto.class);
		Map<String, Integer> params = new HashMap<>();
		params.put("page", page);
		params.put("limit", limit);
		params.put("productId", productId);
		return jdbc.query(CommentSqls.GET_LIST_BY_PRODUCT, params, rowMapper);
	}

	@Override
	public List<Integer> getImageList(int id) {
		Map<String, Integer> params = new HashMap<>();
		params.put("id", id);
		return jdbc.queryForList(CommentSqls.GET_IMAGE_LIST, params, Integer.class);
	}
}
