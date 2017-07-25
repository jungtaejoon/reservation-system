package kr.or.connect.jy.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.connect.jy.dto.CommentDTO;
import kr.or.connect.jy.dto.CommentImageDTO;

@Repository
public class CommentDao {
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<CommentDTO> dtoRowMapper = BeanPropertyRowMapper.newInstance(CommentDTO.class);
	private RowMapper<CommentImageDTO> imageDtoRowMapper = BeanPropertyRowMapper.newInstance(CommentImageDTO.class);

	public CommentDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}

	public List<CommentDTO> selectCommentsByProductIdRecentLimit3(int productId) {
		Map<String, Object> params = new HashMap<>();
		params.put("product_id", productId);

		return jdbc.query(CommentSqls.SELECT_COMMENT_BY_PRODUCT_ID_RECENT_LIMIT3, params, dtoRowMapper);
	}
	
	public Integer countCommentsByProductId(int productId) {
		Map<String, Object> params = new HashMap<>();
		params.put("product_id", productId);

		return jdbc.queryForObject(CommentSqls.COUNT_COMMENT_BY_PRODUCT_ID, params, Integer.class);
	}
	
	public Double sumScoreByProductId(int productId) {
		Map<String, Object> params = new HashMap<>();
		params.put("product_id", productId);

		return jdbc.queryForObject(CommentSqls.SUM_SCORE_BY_PRODUCT_ID, params, Double.class);
	}

	public List<CommentImageDTO> selectImagesByUserCommentId(int commentId) {
		Map<String, Object> params = new HashMap<>();
		params.put("user_comment_id", commentId);

		return jdbc.query(CommentSqls.SELECT_IMEAGE_BY_USER_COMMENT_ID, params, imageDtoRowMapper);
	}
	
}
