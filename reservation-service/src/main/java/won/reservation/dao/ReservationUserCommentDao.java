package won.reservation.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import won.reservation.domain.ReservationUserComment;
import won.reservation.dto.CommentInfo;

@Repository
public class ReservationUserCommentDao {
	
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<ReservationUserComment> rowMapper = BeanPropertyRowMapper.newInstance(ReservationUserComment.class);
	
	public ReservationUserCommentDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource)
				.withTableName("reservation_user_comment")
				.usingGeneratedKeyColumns("id");
	}
	
	public List<CommentInfo> select(Integer productId) {
		RowMapper<CommentInfo> rowMapper = BeanPropertyRowMapper.newInstance(CommentInfo.class);
		Map<String, Integer> params = new HashMap<>();
		params.put("productid", productId);
		return jdbc.query(ReservationUserCommentSqls.SELECT_BY_PRODUCT_ID, params, rowMapper);
	}
	
	public Double selectAvgScore(Integer productId) {
		Map<String, Integer> params = new HashMap<>();
		params.put("productid", productId);
		return jdbc.queryForObject(ReservationUserCommentSqls.SCORE_AVG, params, Double.class);
	}
	
}
