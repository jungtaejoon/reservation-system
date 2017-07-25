package com.soomin.reservation.dao;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.soomin.reservation.domain.Users;

@Repository
public class UsersDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<Users> rowMapper = BeanPropertyRowMapper.newInstance(Users.class);
	
	
	public UsersDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource)
				.withTableName("users")
				.usingGeneratedKeyColumns("id");
	}
	
	public boolean check(long sns_id) {
		Map<String, ?> params = Collections.singletonMap("sns_id", sns_id);
		return jdbc.queryForObject(UsersSqls.CHECK_USER, params, boolean.class);
	}
	
	public long insert(Users user) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(user);
		return insertAction.executeAndReturnKey(params).longValue();
	}
	
	public long update(Users user) {
		Map<String, Object> params = new HashMap<>();
		params.put("sns_id", user.getSns_id());
		params.put("nickname", user.getNickname());
		params.put("email", user.getEmail());
		params.put("name", user.getUsername());
		
		return jdbc.update(UsersSqls.UPDATE_USER, params);
	}
}
