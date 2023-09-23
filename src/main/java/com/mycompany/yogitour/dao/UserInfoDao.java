package com.mycompany.yogitour.dao;

import org.apache.ibatis.annotations.Mapper;

import com.mycompany.yogitour.dto.Media;
import com.mycompany.yogitour.dto.UserInfo;

@Mapper
public interface UserInfoDao {
	public int insert(UserInfo userInfo);
	public UserInfo selectLoginUser(UserInfo userInfo);
	public UserInfo selectUserInfoById(String userId);
	
	
	/**
	 * DB에 유저 프로필 이미지의 바이너리 이진 데이터 요청
	 * @author 고재승
	 * @param userNo (유저 고유번호)
	 * @return BLOB - byte[]
	 */
	public Media selectBattachData(int userNo);
	
	
	/**
	 * USERINFO 테이블에 유저 프로필 사진 이미지 데이터 갱신 요청
	 * @author 고재승
	 * @param Media (미디어 데이터 DTO)
	 */
	public void updateUserProfileImageData(Media media);
}
