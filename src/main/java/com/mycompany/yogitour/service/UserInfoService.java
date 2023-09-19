package com.mycompany.yogitour.service;

import com.mycompany.yogitour.dto.UserInfo;

public interface UserInfoService {
	public static enum LoginResult {
		SUCCESS,
		FAIL_USER_ID,
		FAIL_USER_PASSWORD,
	}
	
	public enum JoinResult {
		SUCCESS,
		FAIL_DUPLICATED_USER_ID
	}
	
	/**
	 * 유저 정보를 가져오는 메소드
	 * @author 고재승
	 * @param userID
	 * @return UserInfo DB DTO
	 */
	public UserInfo getUserInfo(String userId);
	
	/** 로그인 유효성 검증 메소드
	 * @author 고재승
	 * @param userInfo
	 * @return 로그인 ENUM 값
	 */
	public LoginResult login(String userId, String userPassword);
	
	
	/** 회원가입 유효성 검증 메소드
	 * @author 고재승
	 * @param userInfo
	 * @return 회원가입 ENUM 값
	 */
	public JoinResult join (UserInfo userInfo);
	
	
}
