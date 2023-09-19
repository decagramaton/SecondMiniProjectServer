package com.mycompany.yogitour.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mycompany.yogitour.dto.Board;
import com.mycompany.yogitour.dto.Media;
import com.mycompany.yogitour.dto.Product;
import com.mycompany.yogitour.interceptor.Login;
import com.mycompany.yogitour.service.ProductService;
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
}
