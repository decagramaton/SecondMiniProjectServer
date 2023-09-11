package com.mycompany.yogitour.dao;

import org.apache.ibatis.annotations.Mapper;
import com.mycompany.yogitour.dto.UserInfo;

@Mapper
public interface UserInfoDao {
	public int insert(UserInfo userInfo);
	public UserInfo selectUserInfoById(String userId);
}
