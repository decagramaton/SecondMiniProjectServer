package com.mycompany.yogitour.service;

import java.util.List;

import com.mycompany.yogitour.dto.Reservation;
import com.mycompany.yogitour.dto.ReservationDetail;

public interface ReservationService {
	public void setNewReservation(Reservation reservation);
	
	public List<ReservationDetail> getReservationDetailList(int userNo);
}
