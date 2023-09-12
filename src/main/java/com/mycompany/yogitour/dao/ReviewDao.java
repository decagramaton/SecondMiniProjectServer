package com.mycompany.yogitour.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycompany.yogitour.dto.Review;

@Mapper
public interface ReviewDao {
	public List<Review> selectReviewListByProductNo(int productNo);
	
}
