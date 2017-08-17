package dunkirk.reservation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dunkirk.reservation.dao.ReservationDao;
import dunkirk.reservation.domain.ReservationInfo;
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
}
