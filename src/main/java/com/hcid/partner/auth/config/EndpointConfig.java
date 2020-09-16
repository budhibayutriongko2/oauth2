package com.hcid.partner.auth.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix="api")
@PropertySource("file:/file/tippers/api.properties")
public class EndpointConfig {
	
	
///////////////////// Connect To External Service ////////////////////
	
	
	private String urlEnvironment;
	private String utilContextRoot;
	private String notificationContextRoot;
	private String activityContextRoot;

	private String logId;
	private String saveLog;
	
	
	//To tippers Service
	private String tippersContextRoot;
	private String validateAccountNumber;
	
	private String faq;
	private String getCode;
	private String sendEmail;
	private String sendSMS;
	private String createdBy;

}
