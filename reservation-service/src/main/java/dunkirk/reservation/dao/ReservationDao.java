package dunkirk.reservation.dao;

import java.util.List;
import java.util.Map;

import dunkirk.reservation.domain.ReservationInfo;
import dunkirk.reservation.dto.MyReservationDto;

public interface ReservationDao {
	int add(ReservationInfo reservationInfo);
	List<MyReservationDto> getList(int userId);
	Map<String, Object> getReservationTypeCountList(int userId);
}
