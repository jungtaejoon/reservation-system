package kgw.reservation.dao;

import java.util.Collections;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kgw.reservation.domain.User;
import kgw.reservation.sql.UserSqls;

@Repository
public class UserDao {
	private NamedParameterJdbcTemplate jdbc;
    private SimpleJdbcInsert insertAction;
    private RowMapper<User> rowMapper = BeanPropertyRowMapper.newInstance(User.class);
    
    @Autowired
    public UserDao(DataSource dataSource) {
    		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource)
				.withTableName("Users")
				.usingGeneratedKeyColumns("id");
    }
    public Integer insert(User user) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(user);
		return insertAction.executeAndReturnKey(params).intValue();
	}
    
    public User selectBySnsId(String snsId) {
		Map<String, Object> params = Collections.singletonMap("snsId", snsId);
		try {
				return jdbc.queryForObject(UserSqls.SELECT_BY_SNS_ID, params, rowMapper);
		} catch(DataAccessException e) {
				return null;
		}
    }
	

}
