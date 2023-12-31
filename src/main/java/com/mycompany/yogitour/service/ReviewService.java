package com.mycompany.yogitour.service;

import java.util.List;

import com.mycompany.yogitour.dto.Review;

public interface ReviewService {
	public List<Review> getList(int userNo);
	public void addReview(Review review);
	public Integer checkReview (int reservationNo);
	public void removeReview(int reviewNo);
	public void updateReview(int reviewNo, int rating, String content);
}
