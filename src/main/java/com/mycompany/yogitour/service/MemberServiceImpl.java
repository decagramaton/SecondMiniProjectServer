package com.mycompany.yogitour.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mycompany.yogitour.dao.MemberDao;
import com.mycompany.yogitour.dto.Member;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDao memberDao;
	
	
	@Override
	public Member getMember(String mid) {
		Member member = memberDao.selectByMid(mid);
		return member;
	}
	
	
	@Override
	public JoinResult join(Member member) {
		Member dbMember = memberDao.selectByMid(member.getMid());
		
		if(dbMember != null) {
			return JoinResult.FAIL_DUPLICATED_MID;
		} else {
			PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
			member.setMpassword(passwordEncoder.encode(member.getMpassword()));
			
			memberDao.insert(member);
			return JoinResult.SUCCESS;
		}
	}
	
	@Override
	public LoginResult login(Member member) {
		Member dbMember = memberDao.selectByMid(member.getMid());
		
		if(dbMember == null) {
			return MemberService.LoginResult.FAIL_MID;
		}

		PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		
		if(passwordEncoder.matches(member.getMpassword(), dbMember.getMpassword())) {
			if(dbMember.isMenabled()) {
				return LoginResult.SUCCESS;
			} else {
				return LoginResult.FAIL_ENABLED;
			}
		} else {
			return LoginResult.FAIL_MPASSWORD;
		}
	}
	
	@Override
	public void logout(String mid) {
		
	}
	
	@Override
	public void modify(Member member) {
		memberDao.update(member);
		
	}
	
	@Override
	public void unjoin(String mid) {
		Member member = memberDao.selectByMid(mid);
		member.setMenabled(false);
		memberDao.update(member);
	}
}
