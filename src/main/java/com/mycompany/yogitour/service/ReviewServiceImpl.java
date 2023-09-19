package com.mycompany.yogitour.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.yogitour.dao.ReviewDao;
import com.mycompany.yogitour.dto.Review;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ReviewServiceImpl implements ReviewService {
	
	@Autowired
	private ReviewDao reviewDao;
	
	@Override
	public List<Review> getList(int userNo) {
		
		List<Review> reviewList = reviewDao.selectReviewListByUserNo(userNo);
		
		
		return reviewList;
		
	}
	
}
