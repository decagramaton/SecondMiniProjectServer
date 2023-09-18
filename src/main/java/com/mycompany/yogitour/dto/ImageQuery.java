package com.mycompany.yogitour.dto;

import lombok.Data;

@Data
public class ImageQuery {
	private int productNo;
	private String keyword;
	
	public ImageQuery(int productNo, String keyword) {
		this.productNo = productNo;
		this.keyword = keyword;
	}
}
