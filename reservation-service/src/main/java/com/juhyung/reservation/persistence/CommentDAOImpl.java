package com.juhyung.reservation.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.juhyung.reservation.domain.Comment;
import com.juhyung.reservation.domain.PageCriteria;

@Repository
public class CommentDAOImpl implements CommentDAO{
	
	
	private NamedParameterJdbcTemplate jdbc; 
//    private SimpleJdbcInsert insertAction; 
    private RowMapper<Comment> rowMapper = BeanPropertyRowMapper.newInstance(Comment.class);
    
    public CommentDAOImpl(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource); 
    }
    
	@Override
	public List<Comment> selectCommentByProductId(int id) {
		Map<String, Integer> params = new HashMap<>();
        params.put("id", id);
		return jdbc.query(CommentSqls.SELECT_COMMENT_BY_PRODUCT_ID, params, rowMapper);
	}

	@Override
	public List<Comment> selectSampleCommnet(int id, PageCriteria pageCriteria) {
		Map<String, Integer> params = new HashMap<>();
        params.put("id", id);
        params.put("page", pageCriteria.getPage());
        params.put("perNum", pageCriteria.getPerNum());
        return jdbc.query(CommentSqls.SELECT_SAMPLE_COMMENT, params, rowMapper);	
        }
	
	@Override
	public int selectCountComments(int id) {
		Map<String, Integer> params = new HashMap<>();
        params.put("id", id);
        return jdbc.queryForObject(CommentSqls.COUNT_COMMENTS, params, Integer.class);
	}

	@Override
	public Double selectAverageScore(int id) {
		Map<String, Integer> params = new HashMap<>();
        params.put("id", id);
        return jdbc.queryForObject(CommentSqls.AVERAGE_SCORE, params, Double.class);
	}

}
