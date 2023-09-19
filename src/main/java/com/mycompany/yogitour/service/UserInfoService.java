package com.mycompany.yogitour.service;

import com.mycompany.yogitour.dto.Media;
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
	
	/**
	 * 유저 프로필 이미지 데이터 요청
	 * @author 고재승
	 * @param userNo (유저 고유번호)
	 * @return 바이너리 이진 데이터
	 */
	public byte[] getUserProfileImageData(int userNo);
	
	/**
	 * 유저 프로필 이미지 데이터 DB에 저장 요청
	 * @author 고재승
	 * @param media
	 */
	public void setUserProfileImageData(Media media);
	
	
	/** 회원가입 유효성 검증 메소드
	 * @author 고재승
	 * @param userInfo
	 * @return 회원가입 ENUM 값
	 */
	public JoinResult join (UserInfo userInfo);
	
	
}
