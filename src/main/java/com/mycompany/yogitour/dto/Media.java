package com.mycompany.yogitour.dto;

import lombok.Data;

@Data
public class Media {
	private int mediaNo;
	private int productNo;
	private String mediaOriginalName;
	private String mediaType;
	private byte[] mediaData;
}
