package com.mycompany.yogitour.dto;

import java.util.Date;

import lombok.Data;

/**
 * @author 고재승
 * 예약 상세 내역 조회를 위한 DTO객체
 * 예약 DB + 상품 DB 내용이 통합된 복합 DTO
 */
@Data
public class ReservationDetail {
	private int reservationNo;					// 예약 번호
	private int reservationAdultNumber;			// 예약 성인 수
	private int reservationChildNumber;			// 예약 아동 수
	private Date reservationDate;				// 예약 일
	private int reservationState;				// 예약 상태

	private int productNo;						// 상품 번호
	private String productTitle;				// 상품 제목
	private int productAdultPrice;				// 상품 성인 금액
	private int productchildPrice;				// 상품 아동 금액
	private Date tourStartDate;					// 출발 일
	private Date tourEndDate;					// 종료 일
}
