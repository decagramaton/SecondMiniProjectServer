package com.mycompany.yogitour.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mycompany.yogitour.dto.Board;
import com.mycompany.yogitour.dto.Media;
import com.mycompany.yogitour.dto.Product;
import com.mycompany.yogitour.dto.Reservation;
import com.mycompany.yogitour.dto.Review;
import com.mycompany.yogitour.interceptor.Login;
import com.mycompany.yogitour.service.ProductService;
import com.mycompany.yogitour.service.ReservationService;
import com.mycompany.yogitour.service.ReviewService;

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
}
