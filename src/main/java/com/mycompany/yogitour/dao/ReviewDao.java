package com.mycompany.yogitour.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycompany.yogitour.dto.Review;

@Mapper
public interface ReviewDao {
	public List<Review> selectReviewListByProductNo(int productNo);
	public List<Review> selectReviewListByUserNo(int userNo);
	public void insertReview(Review review);
	public Integer checkReview(int reservationNo);
	public void deleteReview(int reviewNo);
	public void updateReview(Review review);
}
