package com.mycompany.yogitour.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mycompany.yogitour.dao.UserInfoDao;
import com.mycompany.yogitour.dao.WishDao;
import com.mycompany.yogitour.dto.UserInfo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class WishServiceImpl implements WishService {
	@Autowired
	private WishDao wishDao;

	@Override
	public int checkWish(int productNo, int userNo) {
		int result = wishDao.checkWish(productNo, userNo);
		return result;
	}
	
	
	
}
