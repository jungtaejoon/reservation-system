package kr.or.connect.reservation.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.domain.UserComment;
import kr.or.connect.reservation.dto.ImageForDetail;

@Repository
public class UserCommentDao {
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<UserComment> rowMapperComment = BeanPropertyRowMapper.newInstance(UserComment.class);
	private RowMapper<ImageForDetail> rowMapperImg = BeanPropertyRowMapper.newInstance(ImageForDetail.class);
	
	public UserCommentDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<UserComment> getAll(Integer productId) {
		Map<String, Object> params = new HashMap<>();
		params.put("productId", productId);
		return jdbc.query(UserCommentSqls.GET_ALL, params, rowMapperComment);
	}
	
	public List<ImageForDetail> getImages(Integer id) {
		Map<String, Object> params = new HashMap<>();
		params.put("id", id);
		return jdbc.query(UserCommentSqls.GET_IMAGES, params, rowMapperImg );
	}
}
