package dunkirk.reservation.dao;

import dunkirk.reservation.domain.ReservationInfo;

public interface ReservationDao {
	int add(ReservationInfo reservationInfo);
}
