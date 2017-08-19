package dunkirk.reservation.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import dunkirk.reservation.dao.ReservationDao;
import dunkirk.reservation.domain.ReservationInfo;
import dunkirk.reservation.domain.ReservationType;
import dunkirk.reservation.dto.MyReservationDto;
import dunkirk.reservation.dto.ReservationTypeCount;
import dunkirk.reservation.sql.ReservationSqls;

@Repository
public class ReservationDaoImpl implements ReservationDao {

	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;

	@Autowired
	public ReservationDaoImpl(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource)
				.withTableName("reservation_info")
				.usingGeneratedKeyColumns("id");
	}

	@Override
	public int add(ReservationInfo reservationInfo) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(reservationInfo);
		return insertAction.execute(params);
	}

	@Override
	public List<MyReservationDto> getList(int userId) {
		RowMapper<MyReservationDto> rowMapper = new BeanPropertyRowMapper<>(MyReservationDto.class);
		Map<String, Integer> params = new HashMap<>();
		params.put("user_id", userId);
		return jdbc.query(ReservationSqls.GET_LIST, params, rowMapper);
	}

	@Override
	public List<ReservationTypeCount> getReservationTypeCountList(int userId) {
		RowMapper<ReservationTypeCount> rowMapper = new BeanPropertyRowMapper<>(ReservationTypeCount.class);
		Map<String, Integer> params = new HashMap<>();
		params.put("user_id", userId);
		return jdbc.query(ReservationSqls.GET_RESERVATION_TYPE_COUNT, params, rowMapper);
	}

	@Override
	public int modifyReservationType(int id, ReservationType reservationType) {
		Map<String, Object> params = new HashMap<>();
		params.put("id", id);
		params.put("reservation_type", reservationType.toString());
		return jdbc.update(ReservationSqls.MODIFY_RESERVATION_TYPE, params);
	}

}
