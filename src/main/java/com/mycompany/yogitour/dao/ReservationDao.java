package com.mycompany.yogitour.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycompany.yogitour.dto.Reservation;
import com.mycompany.yogitour.dto.ReservationDetail;

@Mapper
public interface ReservationDao {
	public void addReservation(Reservation reservation);
	public List<ReservationDetail> selectReservationDetailByUserNo(int userNo);
}
