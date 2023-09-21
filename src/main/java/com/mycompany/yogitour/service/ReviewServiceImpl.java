package com.mycompany.yogitour.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.yogitour.dao.ProductDao;
import com.mycompany.yogitour.dao.ReviewDao;
import com.mycompany.yogitour.dto.Product;
import com.mycompany.yogitour.dto.Review;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ReviewServiceImpl implements ReviewService {
	
	@Autowired
	private ReviewDao reviewDao;
	@Autowired
	private ProductDao productDao;
	
	@Override
	public List<Review> getList(int userNo) {
		
		List<Review> reviewList = reviewDao.selectReviewListByUserNo(userNo);
		List<Review> newReviewList = new ArrayList<>();
		for(Review review : reviewList) {
			int productNo = review.getProductNo();
			Product productInfo = productDao.selectByProductNo(productNo); 
			review.setTourStartDate(productInfo.getTourStartDate());
			review.setTourEndDate(productInfo.getTourEndDate());
			newReviewList.add(review);
		}
		return newReviewList;
		
	}

	@Override
	public void addReview(Review review) {
		reviewDao.insertReview(review);
		
	}

	@Override
	public Integer checkReview(int reservationNo) {
		Integer result = reviewDao.checkReview(reservationNo);
		return result;
	}

	@Override
	public void removeReview(int reviewNo) {
		reviewDao.deleteReview(reviewNo);
		
	}

	
}
