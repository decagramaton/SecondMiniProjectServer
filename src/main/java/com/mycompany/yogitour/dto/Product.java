package com.mycompany.yogitour.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class Product {
	private int productNo;
	private String productTitle;
	private int productAdultPrice;
	private int productChildPrice;
	@DateTimeFormat(pattern="yyyy.MM.dd")
	private Date tourStartDate;
	@DateTimeFormat(pattern="yyyy.MM.dd")
	private Date tourEndDate;
	private String productVehicle;
	private String productVisitPlace;
	private int productReservationNumber;
	private String productContent;
	private String productCategory;
	
	private MultipartFile battach;
	private byte[] productMediaData;
	private String productMediaType;
}
