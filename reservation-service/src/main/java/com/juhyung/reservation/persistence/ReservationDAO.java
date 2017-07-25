package com.juhyung.reservation.persistence;

import com.juhyung.reservation.domain.Reservation;

public interface ReservationDAO {
	
	public int insertReservation(Reservation reservation);

}
