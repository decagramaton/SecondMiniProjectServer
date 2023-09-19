package com.mycompany.yogitour.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mycompany.yogitour.dao.UserInfoDao;
import com.mycompany.yogitour.dao.WishDao;
import com.mycompany.yogitour.dto.UserInfo;
import com.mycompany.yogitour.dto.Wish;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class WishServiceImpl implements WishService {
	@Autowired
	private WishDao wishDao;

	@Override
	public int checkWish(int productNo, int userNo) {
		log.info("서비스 임플 : "+ productNo +" : "+ userNo);
		Wish wish = new Wish();
		wish.setProductNo(productNo);
		wish.setUserNo(userNo);
		int result = wishDao.checkWish(wish);
		log.info("result : "+result);
		return result;
	}

	@Override
	public void clickWishBtn(int productNo, int userNo) {
		Wish wish = new Wish();
		wish.setProductNo(productNo);
		wish.setUserNo(userNo);
		int result = wishDao.checkWish(wish);
		if(result == 0) {
			wishDao.addWish(wish);
		}else if(result ==1) {
			wishDao.deleteWish(wish);
		}
		
	}
	
	
	
}
