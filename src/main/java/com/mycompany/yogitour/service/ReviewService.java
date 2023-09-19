package com.mycompany.yogitour.service;

import java.util.List;

import com.mycompany.yogitour.dto.Review;

public interface ReviewService {
	public List<Review> getList(int userNo);

}
