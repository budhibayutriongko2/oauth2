package com.hcid.partner.auth.dto;


import lombok.Data;




@Data
public class PartnerResponse  {
    
    private String auth;

    
    private String token;

    
    private Long timestamp;

    
    private String code;

    
    private Object object;

   
    private String description;

    private String severity;

    private String message;

    public Long getTimestamp() {
        timestamp = System.currentTimeMillis();
        return timestamp;
    }
}
