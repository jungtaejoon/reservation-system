package dunkirk.reservation.dao.impl;

import dunkirk.reservation.dao.ReservationDao;
import dunkirk.reservation.domain.ReservationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class ReservationDaoImpl implements ReservationDao {

    private SimpleJdbcInsert insertAction;

    @Autowired
    public ReservationDaoImpl(DataSource dataSource) {
        this.insertAction = new SimpleJdbcInsert(dataSource)
                .withTableName("reservation_info")
                .usingGeneratedKeyColumns("id");
    }

    @Override
    public int add(ReservationInfo reservationInfo) {
        BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(reservationInfo);
        return insertAction.execute(params);
    }

}
