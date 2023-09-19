package com.mycompany.yogitour.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.yogitour.dto.Media;
import com.mycompany.yogitour.dto.UserInfo;
import com.mycompany.yogitour.service.UserInfoService;
import com.mycompany.yogitour.service.UserInfoService.JoinResult;
import com.mycompany.yogitour.service.UserInfoService.LoginResult;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/userInfo")
public class UserInfoController {
	
	// 테스트용
	
	@Autowired
	private UserInfoService userInfoService;
	
	/**
	 * 로그인 유효성 검증과 유저 정보를 반환 요청 메소드
	 * @author 고재승
	 * @param userInfo
	 * @return userInfo DTO
	 */
	@RequestMapping(value="/login", produces="application/json; charset=UTF-8")
	public String login(String userId, String userPassword) {		
		
		// Step1. 로그인 성공 여부 확인
		LoginResult loginResult = userInfoService.login(userId, userPassword);
		JSONObject jsonObject = new JSONObject();
		
		// git test
		
		// Step2. 로그인 성공 시, 유저 정보 반환
		if(loginResult == LoginResult.SUCCESS) {
			jsonObject.put("result", "success");	
		// Step3. 로그인 실패 시, 실패 사유 반환
		} else if (loginResult == LoginResult.FAIL_USER_ID) {
			jsonObject.put("result", "fail_user_id");
		} else if (loginResult == LoginResult.FAIL_USER_PASSWORD) {
			jsonObject.put("result", "fail_user_password");
		}

		return jsonObject.toString();
	}
	
	/**
	 * @author 고재승
	 * @param userId (유저 ID)
	 * @return UserInfo DTO
	 */
	@GetMapping(value="/getUserInfo", produces="application/json; charset=UTF-8")
	public UserInfo getUserInfo(String userId) {
		return userInfoService.getUserInfo(userId);
	}
	
	/**
	 * @author 고재승
	 * @param userNo (유저 고유번호)
	 * @return 바이너리 데이터
	 */
	@GetMapping(value="/fileDownload", produces="image/jpeg")
	public byte[] fileDownload(int userNo, String mediaName){
		return userInfoService.getUserProfileImageData(userNo);
	}
	
	
	@PostMapping(value="/join", produces="application/json; charset=UTF-8")
	public String join1(UserInfo userInfo) {
		log.info(userInfo.toString());
		
		JoinResult joinResult = userInfoService.join(userInfo);	
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
