package com.mycompany.yogitour.dto;

import java.util.Date;

import lombok.Data;

@Data
public class UserInfo {
	private int userNo;
	private String userKoName;
	private String userId;
	private String userPassword;
	private Date userBirth;
	private String userPhone;
	private String userGender;
	private String userEnName;
	private String userEmail;
	
	/*private byte[] userProfileImage;*/
}
