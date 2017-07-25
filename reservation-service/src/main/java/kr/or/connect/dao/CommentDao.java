package kr.or.connect.dao;

import java.util.*;

import javax.sql.*;

import org.springframework.dao.*;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.core.namedparam.*;
import org.springframework.stereotype.*;

import kr.or.connect.dto.*;

@Repository
public class CommentDao {

	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<CommentDto> commentDtoRowMapper = BeanPropertyRowMapper.newInstance(CommentDto.class);

	public CommentDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}

	public List<CommentDto> selectByProduct(Long productId, Integer start, Integer amount) {
		Map<String, Object> params = new HashMap<>();
		params.put("productId", productId);
		params.put("start", start);
		params.put("amount", amount);
		return jdbc.query(CommentSqls.SELECT_BY_PRODUCT_ID, params, commentDtoRowMapper);
	}

	public List<Long> getImages(Long id) {
		Map<String, Object> params = new HashMap<>();
		params.put("id", id);
		return jdbc.queryForList(CommentSqls.SELECT_COMMENT_IMAGES, params, Long.class);
	}

	public int getImageCounts(Long id) {
		Map<String, Long> params = new HashMap<>();
		params.put("id", id);
		try {
			return jdbc.queryForObject(CommentSqls.COUNT_COMMENT_IMAGES, params, Integer.class);
		} catch (EmptyResultDataAccessException e) {
			return 0;
		}
	}

}
