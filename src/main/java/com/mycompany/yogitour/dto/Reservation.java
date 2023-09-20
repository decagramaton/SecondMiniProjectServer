package com.mycompany.yogitour.dto;

import java.util.Date;

import lombok.Data;

@Data
public class Reservation {
	private int reservationNo;
	private int productNo;
	private int userNo;
	private int reservationAdultNumber;
	private int reservationChildNumber;
	private Date reservationDate;
	private int reservationState;
}
