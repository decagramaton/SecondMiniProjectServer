package com.mycompany.yogitour.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.yogitour.dto.Reservation;
import com.mycompany.yogitour.service.ReservationService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/reservation")
public class ReservationController {

	@Autowired
	private ReservationService reservationService;
	
	@GetMapping(value="/setNewReservationInfo", produces="application/json; charset=UTF-8")
	public void setNewReservationInfo(int userNo, int productNo, int adultNumber, int childNumber){
		Reservation reservation = new Reservation();
		reservation.setProductNo(productNo);
		reservation.setUserNo(userNo);
		reservation.setReservationAdultNumber(adultNumber);
		reservation.setReservationChildNumber(childNumber);
		reservationService.setNewReservation(reservation);
	}
	
	@GetMapping(value="/getReservationDayList",produces="application/json; charset=UTF-8")
	public List<Date> getReservationDayList(int userNo){
		List<Date> reservationDayList = reservationService.getReservationDay(userNo);
		return reservationDayList;
	}	
	
	@GetMapping(value="/getReservationListByDay",produces="application/json; charset=UTF-8")
	public List<Reservation> getReservationListByDay(long reservationDate , int userNo){
		log.info("여긴 들어오나?");
		log.info("들어오면 날짜는?"+reservationDate);
		log.info("들어오면 유전번호는??" +userNo);
		Date date=new Date(reservationDate);
		List<Reservation> reservationList = reservationService.getReservationByDay(date , userNo);
		log.info("날짜 : "+reservationDate );
		log.info("날짜별 예약 내역 : "+reservationList );
		return reservationList;

	}
	
	@GetMapping(value="/reservationCancel",produces="application/json; charset=UTF-8")
	public void reservationCancel(int reservationNo , int userNo) {
		Reservation reservation = new Reservation();
		reservation.setReservationNo(reservationNo);
		reservation.setUserNo(userNo);
		reservationService.reservationCancel(reservation);
	}
	
	@GetMapping(value="/getThisProductReservationsNo",produces="application/json; charset=UTF-8")
	public Integer getThisProductReservationsNo(int productNo) {
		int result = reservationService.getThisProductReservationsNo(productNo);
		return result;
	}
	
}
