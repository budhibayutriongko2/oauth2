package com.hcid.partner.auth.dto;


import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * Created by rizki.rachman02 on 10/31/2017.
 */

@Data
public class Partner extends BaseDto {

   
    private String id;

    
    private String name;

    
    private String code;

    
    private String type;

    
    private String typeCode;

   
    private String flagConfirm;

  
    private String agreementNumber;

  
    private Date agreementDate;

 
    private List<PartnerSalesroom> partnerSalesroomList;

}
