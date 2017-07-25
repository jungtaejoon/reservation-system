package kr.or.connect.reservation.dao;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.domain.Users;

@Repository
public class UserDAO {

	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<Users> rowMapper = BeanPropertyRowMapper.newInstance(Users.class);
	
	public UserDAO(DataSource dataSource) {
		jdbc = new NamedParameterJdbcTemplate(dataSource);
		insertAction = new SimpleJdbcInsert(dataSource)
				.withTableName("users")
				.usingGeneratedKeyColumns("id");;
	}
	
	public Long insertUser(Users users) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(users);
		return insertAction.executeAndReturnKey(params).longValue();
	}
	
	public Users selectUserById(Long id) {
		Map<String, Object> params = new HashMap<>();
		params.put("id", id);
		try {
			return jdbc.queryForObject(UserSqls.SELECT_USER_BY_ID, params, rowMapper);
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
	}
}
