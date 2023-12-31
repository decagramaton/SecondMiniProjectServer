package com.mycompany.yogitour.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.yogitour.dao.ProductDao;
import com.mycompany.yogitour.dao.ReviewDao;
import com.mycompany.yogitour.dao.WishDao;
import com.mycompany.yogitour.dto.Board;
import com.mycompany.yogitour.dto.ImageQuery;
import com.mycompany.yogitour.dto.Media;
import com.mycompany.yogitour.dto.Product;
import com.mycompany.yogitour.dto.Review;
import com.mycompany.yogitour.dto.Wish;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductDao productDao;
	@Autowired
	private ReviewDao reviewDao;
	@Autowired
	private WishDao wishDao;
	
	@Override
	public void write(Product product) {
		Media media = new Media();
		media.setProductNo(product.getProductNo());
		/*media.setMediaData(product.getProductMediaData());
		media.setMediaType(product.getProductMediaType());*/
		
		productDao.insertProduct(product);
		productDao.insertMedia(media);
	}
	
	@Override
	public void remove(int bno) {
		productDao.deleteByProductNo(bno);
	}
		
	@Override
	public List<Board> getList(String requestType) {
		List<Board> boardList = new ArrayList<>();
		// Step1. Product 정보와 Review 정보를 가져온다.
		
		List<Product> productList = null;
		
		if(requestType.equals("all")) {
			productList = productDao.selectAll();
		} else if (requestType.equals("random")) {
			productList = productDao.selectRandomTen();
		}
		
		// Step2. Product, Review정보를 Board DTO에 하나로 취합한다.
		// 각 Product마다 리뷰 평균 점수와  리뷰 총 개수를 구하고 Board DTO에 취합해야한다.
		for(Product item : productList) {
			List<Review> reviewList = reviewDao.selectReviewListByProductNo(item.getProductNo());
			
			Board board = new Board();
			
			if(reviewList.isEmpty()) {
				Review review = new Review();
				review.setReviewRating(0);
				reviewList.add(review);
			}
			
			// git test용 주석
			
			List<Integer> wishList = wishDao.selectWishListByProductNo(item.getProductNo());
			
			board.setProductNo(item.getProductNo());
			board.setProductTitle(item.getProductTitle());
			board.setProductAdultPrice(item.getProductAdultPrice());
			board.setProductChildPrice(item.getProductChildPrice());
			board.setProductCategory(item.getProductCategory());
			board.setProductContent(item.getProductContent());
			board.setProductReservationNumber(item.getProductReservationNumber());
			board.setProductVehicle(item.getProductVehicle());
			board.setProductVisitPlace(item.getProductVisitPlace());
			board.setTourStartDate(item.getTourStartDate());
			board.setTourEndDate(item.getTourEndDate());
			
			board.setReviewList(reviewList);
			board.setWishUserNo(wishList);
			
			boardList.add(board);
			
		}
		// Step3. Board DTO 반환
		return boardList;
	}
	
	@Override
	public List<Board> getProductListBySearchKeyword(String searchKeyword) {
		List<Board> boardList = new ArrayList<>();
				
		// Step1. Product 정보와 Review 정보를 가져온다.
		List<Product> productList = productDao.selectBySearchKeyword(searchKeyword);
		
		// Step2. Product, Review정보를 Board DTO에 하나로 취합한다.
		// 각 Product마다 리뷰 평균 점수와  리뷰 총 개수를 구하고 Board DTO에 취합해야한다.
		for(Product item : productList) {
			List<Review> reviewList = reviewDao.selectReviewListByProductNo(item.getProductNo());
			
			if(reviewList.isEmpty()) {
				Review review = new Review();
				review.setReviewRating(0);
				reviewList.add(review);
			}

			Board board = new Board();
			board.setProductNo(item.getProductNo());
			board.setProductTitle(item.getProductTitle());
			board.setProductAdultPrice(item.getProductAdultPrice());
			board.setProductChildPrice(item.getProductChildPrice());
			board.setProductCategory(item.getProductCategory());
			board.setProductContent(item.getProductContent());
			board.setProductReservationNumber(item.getProductReservationNumber());
			board.setProductVehicle(item.getProductVehicle());
			board.setProductVisitPlace(item.getProductVisitPlace());
			board.setTourStartDate(item.getTourStartDate());
			board.setTourEndDate(item.getTourEndDate());
			board.setReviewList(reviewList);
			
			List<Integer> wishList = wishDao.selectWishListByProductNo(item.getProductNo());
			board.setWishUserNo(wishList);
			
			boardList.add(board);
		}
		
		return boardList;
	}
	
	@Override
	public Board getProduct(int productNo) {
		Product product = productDao.selectByProductNo(productNo);
		List<Review> reviewList = reviewDao.selectReviewListByProductNo(product.getProductNo());
		Board board = new Board();
		
		if(reviewList.isEmpty()) {
			Review review = new Review();
			review.setReviewRating(0);
			reviewList.add(review);
		}
		
		board.setProductNo(product.getProductNo());
		board.setProductTitle(product.getProductTitle());
		board.setProductAdultPrice(product.getProductAdultPrice());
		board.setProductChildPrice(product.getProductChildPrice());
		board.setProductCategory(product.getProductCategory());
		board.setProductContent(product.getProductContent());
		board.setProductReservationNumber(product.getProductReservationNumber());
		board.setProductVehicle(product.getProductVehicle());
		board.setProductVisitPlace(product.getProductVisitPlace());
		board.setProductVideoUrl(product.getProductVideoUrl());
		board.setTourStartDate(product.getTourStartDate());
		board.setTourEndDate(product.getTourEndDate());
		board.setReviewList(reviewList);
		return board;
	}
	
	@Override
	public Media getProductOnlyAttachData(int productNo, String mediaName) {
		return productDao.selectBattachData(new ImageQuery(productNo, mediaName));
	}
	
	@Override
	public List<Board> getListByCategory(String category) {
		List<Board> boardList = new ArrayList<>();
		
		// Step1. Product 정보와 Review 정보를 가져온다.
		List<Product> productList = productDao.selectProductListByCategory(category);
		
		// Step2. Product, Review정보를 Board DTO에 하나로 취합한다.
		// 각 Product마다 리뷰 평균 점수와  리뷰 총 개수를 구하고 Board DTO에 취합해야한다.
		for(Product item : productList) {
			List<Review> reviewList = reviewDao.selectReviewListByProductNo(item.getProductNo());
			
			if(reviewList.isEmpty()) {
				Review review = new Review();
				review.setReviewRating(0);
				reviewList.add(review);
			}

			Board board = new Board();
			board.setProductNo(item.getProductNo());
			board.setProductTitle(item.getProductTitle());
			board.setProductAdultPrice(item.getProductAdultPrice());
			board.setProductChildPrice(item.getProductChildPrice());
			board.setProductCategory(item.getProductCategory());
			board.setProductContent(item.getProductContent());
			board.setProductReservationNumber(item.getProductReservationNumber());
			board.setProductVehicle(item.getProductVehicle());
			board.setProductVisitPlace(item.getProductVisitPlace());
			board.setTourStartDate(item.getTourStartDate());
			board.setTourEndDate(item.getTourEndDate());
			board.setReviewList(reviewList);
			
			List<Integer> wishList = wishDao.selectWishListByProductNo(item.getProductNo());
			board.setWishUserNo(wishList);
			
			boardList.add(board);
		}
		
		return boardList;
	}
	
	@Override
	public Product getProductDetail(int productNo) {
		
		return null;
	}
}
