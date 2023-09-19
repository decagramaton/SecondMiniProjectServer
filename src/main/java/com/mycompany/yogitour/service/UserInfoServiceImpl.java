package com.mycompany.yogitour.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mycompany.yogitour.dao.UserInfoDao;
import com.mycompany.yogitour.dto.UserInfo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserInfoServiceImpl implements UserInfoService {
	@Autowired
	private UserInfoDao userInfoDao;
	
	
	@Override
	public UserInfo getUserInfo(String userId) {
		return userInfoDao.selectUserInfoById(userId);
	}
	
	
	@Override
	public LoginResult login(String userId) {
		UserInfo dbUserInfo = userInfoDao.selectUserInfoById(userId);
		
		if(dbUserInfo == null) {
			log.info("실행되면 안되는데?");
			return UserInfoService.LoginResult.FAIL_USER_ID;
		}
		
		return LoginResult.SUCCESS;

		/*PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		
		if(passwordEncoder.matches(userInfo.getUserPassword(), dbUserInfo.getUserPassword())) {
			return LoginResult.SUCCESS;
		} else {
			return LoginResult.FAIL_USER_PASSWORD;
		}*/
	}
	
	@Override
	public JoinResult join(UserInfo userInfo) {
		UserInfo dbUserInfo = userInfoDao.selectUserInfoById(userInfo.getUserId());
		
		if(dbUserInfo != null) {
			return JoinResult.FAIL_DUPLICATED_USER_ID;
		} else {
			PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
			userInfo.setUserPassword(passwordEncoder.encode(dbUserInfo.getUserPassword()));
			
			userInfoDao.insert(userInfo);
			return JoinResult.SUCCESS;
		}
	}
}
