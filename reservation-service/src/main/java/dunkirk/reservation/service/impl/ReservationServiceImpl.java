package dunkirk.reservation.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dunkirk.reservation.dao.ReservationDao;
import dunkirk.reservation.domain.ReservationInfo;
import dunkirk.reservation.dto.MyReservationDto;
import dunkirk.reservation.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService {

	private ReservationDao reservationDao;

	@Autowired
	public ReservationServiceImpl(ReservationDao reservationDao) {
		this.reservationDao = reservationDao;
	}

	public int add(ReservationInfo reservationInfo) {
		return reservationDao.add(reservationInfo);
	}

	@Override
	public List<MyReservationDto> getList(int userId) {
		return reservationDao.getList(userId);
	}

	@Override
	public Map<String, Object> getReservationTypeCountList(int userId) {
		return reservationDao.getReservationTypeCountList(userId);
	}
}
