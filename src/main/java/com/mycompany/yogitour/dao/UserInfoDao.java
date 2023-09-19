package com.mycompany.yogitour.dao;

import org.apache.ibatis.annotations.Mapper;

import com.mycompany.yogitour.dto.Media;
import com.mycompany.yogitour.dto.UserInfo;

@Mapper
public interface UserInfoDao {
	public int insert(UserInfo userInfo);
	public int selectLoginUser(UserInfo userInfo);
	public UserInfo selectUserInfoById(String userId);
	
	
	/**
	 * DB에 유저 프로필 이미지의 바이너리 이진 데이터 요청
	 * @author 고재승
	 * @param userNo (유저 고유번호)
	 * @return BLOB - byte[]
	 */
	public Media selectBattachData(int userNo);
}
