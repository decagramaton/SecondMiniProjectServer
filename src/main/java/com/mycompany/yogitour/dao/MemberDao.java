package com.mycompany.yogitour.dao;


import org.apache.ibatis.annotations.Mapper;

import com.mycompany.yogitour.dto.Member;

@Mapper
public interface MemberDao {
	public int insert(Member member);
	public Member selectByMid(String mid);
	public int update(Member member);
}
