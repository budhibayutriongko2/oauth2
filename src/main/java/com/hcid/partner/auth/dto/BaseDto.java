package com.hcid.partner.auth.dto;


import lombok.Data;


import java.util.Date;

/**
 * Created by andry.sunandar01 on 05/04/2018.
 */
@Data
public abstract class BaseDto {

   
    private Date createdDate;

    
    private Date updatedDate;

 
    private String createdBy;

  
    private String updatedBy;

   
    private String isDelete;

 
   
}
