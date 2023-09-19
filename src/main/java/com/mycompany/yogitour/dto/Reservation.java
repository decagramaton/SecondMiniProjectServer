package com.mycompany.yogitour.dto;

import lombok.Data;

@Data
public class Reservation {
	private int reservationNo;
	private int productNo;
	private int userNo;
	private int reservationAdultNumber;
	private int reservationChildNumber;
	private int reservationState;
}
