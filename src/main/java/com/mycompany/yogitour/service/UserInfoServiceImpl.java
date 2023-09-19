package com.mycompany.yogitour.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mycompany.yogitour.dao.UserInfoDao;
import com.mycompany.yogitour.dto.ImageQuery;
import com.mycompany.yogitour.dto.Media;
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
	public LoginResult login(String userId, String userPassword) {
		
		int dbUserNo = userInfoDao.selectLoginUser(new UserInfo(userId, userPassword));
		
		if(dbUserNo == 0) {
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
	
	/**
	 * 유저 프로필 이미지 데이터 요청
	 * @author 고재승
	 * @param userNo (유저 고유번호)
	 * @return 바이너리 이진 데이터
	 */
	public byte[] getUserProfileImageData(int userNo) {
		Media media = userInfoDao.selectBattachData(userNo);
		return media.getMediaData();
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
