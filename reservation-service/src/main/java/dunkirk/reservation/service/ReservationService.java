package dunkirk.reservation.service;

import java.util.List;
import java.util.Map;

import dunkirk.reservation.domain.ReservationInfo;
import dunkirk.reservation.dto.MyReservationDto;

public interface ReservationService {
	int add(ReservationInfo reservationInfo);
	List<MyReservationDto> getList(int userId);
	List<Map<String, Object>> getReservationTypeCountList(int userId);
}
