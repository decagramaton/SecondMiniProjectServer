package com.mycompany.yogitour.service;

import java.util.Date;
import java.util.List;

import com.mycompany.yogitour.dto.Reservation;

public interface ReservationService {
	public void setNewReservation(Reservation reservation);
	public List<Date> getReservationDay(int userNo);
	public List<Reservation> getReservationByDay(Date day, int userNo);
}
