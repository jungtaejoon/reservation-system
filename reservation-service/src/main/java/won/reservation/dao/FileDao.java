package won.reservation.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.mockito.internal.matchers.InstanceOf;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import won.reservation.domain.File;

@Repository
public class FileDao {
	
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<File> rowMapper = BeanPropertyRowMapper.newInstance(File.class);
	
	public FileDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource)
				.withTableName("file")
				.usingGeneratedKeyColumns("id");
	}
	
	public List<File> selectByProductId(Integer productId) {
		Map<String, Integer> params = new HashMap<>();
		params.put("productid", productId);
		return jdbc.query(FileSqls.SELECT_BY_PRODUCT_ID, params, rowMapper);
	}
	
	public List<File> selectDetailByProductId(Integer productId) {
		Map<String, Integer> params = new HashMap<>();
		params.put("productid", productId);
		return jdbc.query(FileSqls.SELECT_DETAIL_BY_PRODUCT_ID, params, rowMapper);
	}
	
	public List<File> selectByReservationUserCommentId(Integer reservationUserCommentId) {
		Map<String, Integer> params = new HashMap<>();
		params.put("commentid", reservationUserCommentId);
		return jdbc.query(FileSqls.SELECT_COMMENT_BY_PRODUCT_ID, params, rowMapper);
	}
	
	public String selectById(Integer fileId) {
		Map<String, Integer> params = new HashMap<>();
		params.put("fileid", fileId);
		return jdbc.queryForObject(FileSqls.SELECT_BY_ID, params, String.class);
	}
	
}
