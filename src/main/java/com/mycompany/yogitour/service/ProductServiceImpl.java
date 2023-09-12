package com.mycompany.yogitour.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.yogitour.dao.ProductDao;
import com.mycompany.yogitour.dao.ReviewDao;
import com.mycompany.yogitour.dto.Board;
import com.mycompany.yogitour.dto.Media;
import com.mycompany.yogitour.dto.Product;
import com.mycompany.yogitour.dto.Review;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductDao productDao;
	@Autowired
	private ReviewDao reviewDao;
	
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
	public List<Board> getList() {
		List<Board> boardList = new ArrayList<>();
		
		
		// Step1. Product 정보와 Review 정보를 가져온다.
		List<Product> productList = productDao.selectAll();
		
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
			boardList.add(board);
		}
		// Step3. Board DTO 반환
		
		return boardList;
	}
	
	@Override
	public Product getProduct(int productNo) {
		Product product = productDao.selectByProductNo(productNo);
		return product;
	}
	
	@Override
	public Media getProductOnlyAttachData(int productNo) {
		Media media = productDao.selectBattachDataByProductNo(productNo);
		return media;
	}
	
	@Override
	public List<Product> getListByCategory(String category) {
		return productDao.selectProductListByCategory(category);
	}
}
