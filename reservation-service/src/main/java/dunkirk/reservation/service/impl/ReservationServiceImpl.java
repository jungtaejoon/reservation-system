package dunkirk.reservation.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dunkirk.reservation.dao.ReservationDao;
import dunkirk.reservation.domain.ReservationInfo;
import dunkirk.reservation.domain.ReservationType;
import dunkirk.reservation.dto.MyReservationDto;
import dunkirk.reservation.dto.ReservationTypeCount;
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
	public Map<String, Integer> getReservationTypeCountList(int userId) {
		Map<String, Integer> result = new HashMap<>();
		int totalCount = 0;
		int i = 0;
		int requestAndDueCount = 0;
		for(ReservationTypeCount rtc : reservationDao.getReservationTypeCountList(userId)) {
			if(rtc.getReservationType() == ReservationType.REQUESTING || rtc.getReservationType() == ReservationType.DUE) {
				requestAndDueCount += rtc.getCount();
				result.put("이용예정", requestAndDueCount);
			}else {
				result.put(rtc.getReservationType().getName(), rtc.getCount());
			}
			totalCount += rtc.getCount();
		}
		result.put("전체", totalCount);
		return result;
	}
}
