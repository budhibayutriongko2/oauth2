package com.hcid.partner.auth.dto;



import lombok.Data;

@Data
public class Request {

	private String name;

	private User partnerUser;
	private String salesroomCode;
	
	private String activityId;
	private String value;
	
	 private String bankCode;
	 private String bankName;

	 private String accountName;
	 private String accountNumber;
	 private String emailOrPhone;
}
