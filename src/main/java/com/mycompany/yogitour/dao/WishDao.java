package com.mycompany.yogitour.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycompany.yogitour.dto.Product;
import com.mycompany.yogitour.dto.Review;
import com.mycompany.yogitour.dto.Wish;

@Mapper
public interface WishDao {
	public int checkWish(Wish wish);
	public void addWish(Wish wish);
	public void deleteWish(Wish wish);
	public List<Product> selectWishListByUserNo(int userNo);
	public List<Integer> selectWishListByProductNo(int productNo);
}
