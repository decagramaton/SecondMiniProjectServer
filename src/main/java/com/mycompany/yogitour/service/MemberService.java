package com.mycompany.yogitour.service;

import com.mycompany.yogitour.dto.Member;

public interface MemberService {
	public static enum LoginResult {
		SUCCESS,
		FAIL_MID,
		FAIL_MPASSWORD,
		FAIL_ENABLED
	}
	
	public enum JoinResult {
		SUCCESS,
		FAIL_DUPLICATED_MID
	}
	
	public JoinResult join (Member member);
	public LoginResult login(Member member);
	public void modify(Member member);
	public void unjoin(String mid);
	public void logout(String mid);
	public Member getMember(String mid);
	
	
}
