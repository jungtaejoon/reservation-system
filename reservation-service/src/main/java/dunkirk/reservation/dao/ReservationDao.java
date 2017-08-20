package dunkirk.reservation.dao;

import java.util.List;

import dunkirk.reservation.domain.ReservationInfo;
import dunkirk.reservation.domain.ReservationType;
import dunkirk.reservation.dto.MyReservationDto;
import dunkirk.reservation.dto.ReservationTypeCount;

public interface ReservationDao {
    int add(ReservationInfo reservationInfo);

    List<MyReservationDto> getList(int userId);

    List<ReservationTypeCount> getReservationTypeCountList(int userId);

    int modifyReservationType(int id, ReservationType reservationType);
}
