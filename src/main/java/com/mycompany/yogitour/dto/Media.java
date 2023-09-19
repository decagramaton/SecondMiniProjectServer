package com.mycompany.yogitour.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class Media {
	private int mediaNo;
	private int productNo;
	private String mediaName;
	private String mediaType;
	private byte[] mediaData;
	
	private MultipartFile battach;
	private String userNo;
}
