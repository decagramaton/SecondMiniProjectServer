package com.mycompany.yogitour.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycompany.yogitour.dto.Reservation;

@Mapper
public interface ReservationDao {
	public void addReservation(Reservation reservation);
	public List<Date> getReservationDay(int userNo);
	public List<Reservation> getReservationByDay(Reservation reservation);
	
}
