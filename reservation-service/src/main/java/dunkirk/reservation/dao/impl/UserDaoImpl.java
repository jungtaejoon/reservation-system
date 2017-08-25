package dunkirk.reservation.dao.impl;

import java.util.*;

import javax.sql.*;

import dunkirk.reservation.domain.User;
import dunkirk.reservation.sql.UserSqls;
import org.springframework.dao.*;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.core.namedparam.*;
import org.springframework.jdbc.core.simple.*;
import org.springframework.stereotype.*;

import dunkirk.reservation.dao.UserDao;

@Repository
public class UserDaoImpl implements UserDao {
    private NamedParameterJdbcTemplate jdbc;
    private SimpleJdbcInsert insertAction;
    private RowMapper<User> rowMapper = BeanPropertyRowMapper.newInstance(User.class);

    public UserDaoImpl(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.insertAction = new SimpleJdbcInsert(dataSource).withTableName("users").usingGeneratedKeyColumns("id");
    }

    public User getByEmail(String email) {
        Map<String, String> params = new HashMap<>();
        params.put("email", email);
        try {
            return jdbc.queryForObject(UserSqls.SELECT_BY_EMAIL, params, rowMapper);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public User add(User user) {
        SqlParameterSource params = new BeanPropertySqlParameterSource(user);
        user.setId(insertAction.executeAndReturnKey(params).intValue());
        return user;
    }

    public User modify(User user) {
        SqlParameterSource params = new BeanPropertySqlParameterSource(user);
        jdbc.update(UserSqls.UPDATE_BY_NAVER_USER, params);
        return user;
    }
}
