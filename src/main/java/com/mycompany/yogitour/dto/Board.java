package com.mycompany.yogitour.dto;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class Board {
	private int productNo;
	private String productTitle;
	private int productAdultPrice;
	private int productChildPrice;
	private Date tourStartDate;
	private Date tourEndDate;
	private String productVehicle;
	private String productVisitPlace;
	private int productReservationNumber;
	private String productContent;
	private String productCategory;
	private String productVideoUrl;
	
	List<Review> reviewList;		// 상품의 리뷰 목록
	List<Integer> wishUserNo;		// 상품을 찜한 유저 번호 목록
}
