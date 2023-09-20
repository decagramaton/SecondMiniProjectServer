package com.mycompany.yogitour.service;

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
	public List<ReservationDetail> getReservationDetailList(int userNo) {
		return reservationDao.selectReservationDetailByUserNo(userNo);
	}
	
	
}
