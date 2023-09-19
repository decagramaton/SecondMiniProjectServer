package com.mycompany.yogitour.dao;

import org.apache.ibatis.annotations.Mapper;

import com.mycompany.yogitour.dto.Reservation;

@Mapper
public interface ReservationDao {
	public void addReservation(Reservation reservation);
	
}
