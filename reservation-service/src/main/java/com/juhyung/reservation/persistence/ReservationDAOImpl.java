package com.juhyung.reservation.persistence;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.juhyung.reservation.domain.Reservation;

@Repository
public class ReservationDAOImpl implements ReservationDAO{

	private NamedParameterJdbcTemplate jdbc; 
    private SimpleJdbcInsert insertAction; 
    private RowMapper<Reservation> rowMapper = BeanPropertyRowMapper.newInstance(Reservation.class); 
    
    public ReservationDAOImpl(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource); 
        this.insertAction = new SimpleJdbcInsert(dataSource) 
                .withTableName("reservation_info")   
                .usingGeneratedKeyColumns("id"); 
    }
	
	@Override
	public int insertReservation(Reservation reservation) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(reservation);
        return insertAction.executeAndReturnKey(params).intValue();
	}

	
}
