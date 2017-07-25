package com.juhyung.reservation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juhyung.reservation.domain.Reservation;
import com.juhyung.reservation.persistence.ReservationDAO;

@Service
public class ReservationServiceImpl implements ReservationService{

	private ReservationDAO reservationDao;
	
	@Autowired
	public ReservationServiceImpl(ReservationDAO reservationDao) {
		this.reservationDao = reservationDao; 
	}
	
	@Override
	public int setReservation(Reservation reservation) {
		return reservationDao.insertReservation(reservation);
	}

	
}
