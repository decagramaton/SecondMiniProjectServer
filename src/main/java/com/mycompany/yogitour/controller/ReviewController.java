package com.mycompany.yogitour.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.yogitour.dto.Review;
import com.mycompany.yogitour.service.ReviewService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/review")
public class ReviewController {

	@Autowired
	private ReviewService reviewService;	
	
	@GetMapping(value="/getReviewListByUserNo", produces="application/json; charset=UTF-8")
	public List<Review> getReviewListByUserNo(int userNo){
		List<Review> reviewList = reviewService.getList(userNo);
		return reviewList;
	}
	
	@GetMapping(value="/addReview",produces="application/json; charset=UTF-8")
	public void addReview(String title, int rating, String content, int reservationNo,
							int userNo, int productNo) {
		Review review = new Review();
		review.setReviewTitle(title);
		review.setReviewRating(rating);
		review.setReviewContent(content);
		review.setReservationNo(reservationNo);
		review.setUserNo(userNo);
		review.setProductNo(productNo);
		reviewService.addReview(review);
	}
	
	@GetMapping(value="/checkReview", produces="application/json; charset=UTF-8")
	public Integer checkReview(int reservationNo) {
		return reviewService.checkReview(reservationNo);
	}
	
	@GetMapping(value="/removeReview",produces="application/json; charset=UTF-8")
	public void removeReview(int reviewNo) {
		reviewService.removeReview(reviewNo);
	}
	

	@PostMapping(value="/updateReview",produces="application/json; charset=UTF-8")
	public void updateReview(int reviewNo, int rating, String content) {
		reviewService.updateReview(reviewNo, rating, content);
	}

}
