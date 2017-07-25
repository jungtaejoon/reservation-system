package won.reservation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import won.reservation.dao.ReservationInfoDao;
import won.reservation.domain.ReservationInfo;
import won.reservation.service.ReservationInfoService;

@Service
public class ReservationInfoServiceImpl implements ReservationInfoService {

	private ReservationInfoDao dao;
	
	@Autowired
	public ReservationInfoServiceImpl(ReservationInfoDao dao) {
		this.dao = dao;
	}
	
	@Override
	public int add(ReservationInfo reservationInfo) {
		return dao.insert(reservationInfo);
	}
	
}
