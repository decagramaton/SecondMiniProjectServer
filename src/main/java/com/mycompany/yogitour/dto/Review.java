package com.mycompany.yogitour.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class Review {
	private int reviewNo;
	private int productNo;
	private int reservationNo;
	private int userNo;
	private String reviewTitle;
	private String reviewContent;
	private Date reviewDate;
	private int reviewRating;
}
