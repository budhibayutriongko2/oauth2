package com.hcid.partner.auth.dto;

import lombok.Data;

import java.util.Date;

/**
 * Created by yusep.maulana07 on 15/03/2018.
 */
@Data
public class PartnerStatus{

    
    private String id;


    private String statusCode;

    private String statusName;

   
    private Date createdDate;

   
    private String createdBy;

   
    private Date updateDate;

   
    private String updatedBy;


    private String isDelete;

    
    private String descEn;

    
    private String descIn;

}
