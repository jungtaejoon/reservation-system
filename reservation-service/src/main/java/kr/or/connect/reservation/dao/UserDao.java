package kr.or.connect.reservation.dao;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.domain.User;

@Repository
public class UserDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<User> rowMapper = BeanPropertyRowMapper.newInstance(User.class);
	
	public UserDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource)
				.withTableName("users")
				.usingGeneratedKeyColumns("id")
				.usingGeneratedKeyColumns("admin_flag");
	}
	
	public Long add(User user) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(user);
		return insertAction.executeAndReturnKey(params).longValue();
	}
	
	public User getById(Integer id) {
		Map<String, Object> params = new HashMap<>();
		params.put("id", id);
		return jdbc.queryForObject(UserSqls.SELECT_BY_ID, params, rowMapper);
	}
	
	public Integer update(User user) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(user);
		return jdbc.update(UserSqls.UPDATE_BY_ID, params);
	}
	
	public Integer updateAdmin(Integer adminFlag) {
		Map<String, Object> params = new HashMap<>();
		params.put("adminFlag", adminFlag);
		return jdbc.update(UserSqls.UPDATE_ADMIN_BY_ID, params);
	}
	
	public Integer delete(Integer id) {
		Map<String, ?> params = Collections.singletonMap("id",id);
		return jdbc.update(UserSqls.DELETE_BY_ID, params);
	}
	
	public List<User> getAll() {
		Map<String, Object> params = Collections.emptyMap();	
		return jdbc.query(UserSqls.SELECT_ALL, params, rowMapper);
	}
	
	public User getByNaverId(Integer naverId) {
		Map<String, Object> params = new HashMap<>();
		params.put("naverId", naverId);
		return jdbc.queryForObject(UserSqls.SELECT_BY_NAVER_ID, params, User.class);
	}
	
	public Integer existByNaverId(Integer naverId) {
		Map<String, Object> params = new HashMap<>();
		params.put("naverId", naverId);
		return jdbc.queryForObject(UserSqls.EXISTS_BY_NAVER_ID, params, Integer.class);
	}
	
	public Integer updateByNaverId(User user) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(user);
		return jdbc.update(UserSqls.UPDATE_BY_NAVER_ID, params);
	}
}
