package com.mycompany.yogitour.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.yogitour.dto.Product;
import com.mycompany.yogitour.dto.Wish;
import com.mycompany.yogitour.service.WishService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/wish")
public class WishController {

	@Autowired
	private WishService wishService;	
	
	//찜 여부 확인
	@GetMapping(value="/checkWishByUserNoAndProductNo", produces="application/json; charset=UTF-8")
	public int checkWishByUserNoAndProductNo(int productNo, int userNo){
		int result = wishService.checkWish(productNo, userNo);
		return result;
	}
	//찜 버튼 클릭 시 찜 활성화/비활성화
	@GetMapping(value="/clickWishBtn", produces="application/json; charset=UTF-8")
	public void clickWishBtn(int productNo, int userNo){
		log.info("상품번호, 유저번호  " + productNo +  " : " +userNo);
		wishService.clickWishBtn(productNo, userNo);
	}
	
	@GetMapping(value="/getWishListByUserNo", produces="application/json; charset=UTF-8")
	public List<Product> getWishListByUserNo(int userNo) {
		return wishService.getWish(userNo);
	}
	
	@GetMapping(value="/deleteWish", produces="application/json; charset=UTF-8")
	public void deleteWish(int productNo, int userNo) {
		wishService.deleteWish(productNo, userNo);
	}
}
