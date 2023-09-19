package com.mycompany.yogitour.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.yogitour.dao.ReservationDao;
import com.mycompany.yogitour.dto.Reservation;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ReservationServiceImpl implements ReservationService {
	@Autowired
	private ReservationDao reservationDao;
	
	@Override
	public void setNewReservation(Reservation reservation) {
		log.info("서비스 임플의 정보 : "+ reservation);
		reservationDao.addReservation(reservation);
		
	}
	
	
	
	
}
