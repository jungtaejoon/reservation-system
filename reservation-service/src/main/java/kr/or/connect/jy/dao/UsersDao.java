package kr.or.connect.jy.dao;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.or.connect.jy.dto.Users;

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
	
	public int insert(Users user) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(user);
		return insertAction.executeAndReturnKey(params).intValue();
	}

	public Integer countByEmail(String email) {
		HashMap<String, Object> paramMap = new HashMap<>();
		paramMap.put("email", email);
		
		return jdbc.queryForObject("select count(1) from users where email=:email", paramMap, Integer.class);
	}
	
	public Users selectByEmail(String email) {
		HashMap<String, Object> paramMap = new HashMap<>();
		paramMap.put("email", email);
		
		return jdbc.queryForObject(UsersSqls.SELECT_BY_EMAIL, paramMap, rowMapper);
	}
}
