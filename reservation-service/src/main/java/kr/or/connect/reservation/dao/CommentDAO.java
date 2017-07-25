package kr.or.connect.reservation.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.domain.File;
import kr.or.connect.reservation.domain.ReservationUserComment;

@Repository
public class CommentDAO {

	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<ReservationUserComment> rowMapper = BeanPropertyRowMapper.newInstance(ReservationUserComment.class);
	private RowMapper<File> fileRowMapper = BeanPropertyRowMapper.newInstance(File.class);

	public CommentDAO(DataSource dataSource) {
		jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<ReservationUserComment> selectComments(int id) {
		try {
			Map<String, Object> params = new HashMap<>();
			params.put("id", id);
			return jdbc.query(CommentSqls.SELECT_COMMENT_BY_PRODUCTID, params, rowMapper);
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
	}

	public File selectCommentImage(int id) {
		try {
			Map<String, Object> params = new HashMap<>();
			params.put("id", id);
			return jdbc.queryForObject(CommentSqls.SELECT_COMMENTIMAGE_BY_ID, params, fileRowMapper);
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
	}

	public Map<String, Object> selectCommentsCount(int id) {
		try{
			Map<String, Object> params = new HashMap<>();
			params.put("id", id);
			
			return jdbc.queryForMap(CommentSqls.SELECT_COMMENT_COUNT_BY_PRODUCTID, params);
			
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
	}

}
