package com.mycompany.yogitour.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.yogitour.dto.Member;
import com.mycompany.yogitour.service.MemberService;
import com.mycompany.yogitour.service.MemberService.JoinResult;
import com.mycompany.yogitour.service.MemberService.LoginResult;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/member")
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value="/login", produces="application/json; charset=UTF-8")
	public String login(Member member) {
		LoginResult loginResult = memberService.login(member);
		JSONObject jsonObject = new JSONObject();
		
		if(loginResult == LoginResult.SUCCESS) {
			jsonObject.put("result", "success");
			
			Member dbMember = memberService.getMember(member.getMid());
			jsonObject.put("mid", dbMember.getMid());
			jsonObject.put("mpassword", dbMember.getMpassword());
			
		} else if (loginResult == LoginResult.FAIL_ENABLED) {
			jsonObject.put("result", "fail_enabled");
		} else if (loginResult == LoginResult.FAIL_MID) {
			jsonObject.put("result", "fail_mid");
		} else if (loginResult == LoginResult.FAIL_MPASSWORD) {
			jsonObject.put("result", "fail_mpassword");
		}
		
		String json = jsonObject.toString();
		return json;
	}
	
	
	@PostMapping(value="/join1", produces="application/json; charset=UTF-8")
	public String join1(Member member) {
		log.info(member.toString());
		
		JoinResult joinResult = memberService.join(member);	
		JSONObject jsonObject = new JSONObject();
		
		if(joinResult == JoinResult.SUCCESS) {
			jsonObject.put("result", "success");
		} else {
			jsonObject.put("result", "fail");
			jsonObject.put("message", "중복된 아이디가 있습니다.");
		}	
		
		return jsonObject.toString();
	}
	
	
	@PostMapping(value="/join2", produces="application/json; charset=UTF-8")
	public String join2(@RequestBody Member member) {
		log.info(member.toString());
		
		JoinResult joinResult = memberService.join(member);	
		JSONObject jsonObject = new JSONObject();
		
		if(joinResult == JoinResult.SUCCESS) {
			jsonObject.put("result", "success");
		} else {
			jsonObject.put("result", "fail");
			jsonObject.put("message", "중복된 아이디가 있습니다.");
		}	
		
		return jsonObject.toString();
	}
	
}
