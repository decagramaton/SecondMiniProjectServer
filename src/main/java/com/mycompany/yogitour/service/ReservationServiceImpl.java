package com.mycompany.yogitour.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.yogitour.dao.ReservationDao;
import com.mycompany.yogitour.dto.Reservation;
import com.mycompany.yogitour.dto.ReservationDetail;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ReservationServiceImpl implements ReservationService {
	@Autowired
	private ReservationDao reservationDao;
	
	@Override
	public void setNewReservation(Reservation reservation) {
		reservationDao.addReservation(reservation);
		
	}

	@Override
	public List<Date> getReservationDay(int userNo) {
		List<Date> reservationDayList = reservationDao.getReservationDay(userNo);
		return reservationDayList;
	}

	@Override
	public List<Reservation> getReservationByDay(Date day, int userNo ) {
		Reservation reservation = new Reservation();
		reservation.setReservationDate(day);
		reservation.setUserNo(userNo);
		List<Reservation> reservationList =  reservationDao.getReservationByDay(reservation);
		return reservationList;
	}

	@Override
	public void reservationCancel(Reservation reservation) {
		reservationDao.reservationCancel(reservation);
		
	}
	
}
