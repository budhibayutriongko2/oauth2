package com.hcid.partner.auth.dto;

import lombok.Data;




import javax.persistence.*;

import java.sql.Timestamp;
import java.util.Date;



@Data
public class User {


    private String id;

    

    private String username;


    private String pass;



    private String email;


    private String phoneNumber;

    private Date createdDate;


    private String createdBy;


    private Date updatedDate;


    private String updatedBy;

    private String isDelete;


    private String firstName;



    private String lastName;


    private String employeeCode;


    private String partnerStatus;

    private String ktpNumber;
    
    /* tippers start */

    private String npwpNumber;
    

    private String bankCode;

    private String npwpAddress;
    

    private String accountNumber;

    private String accountName;


    private String promotor;

    private String isSelfRegist;
    
    
    private String tippersStatus;
    
    private Date deactivateDate;
    private Date tncDate;
    private Date cocDate;	
    private String otpNumber;
    
    

    /* tippers end */



    @PrePersist
    protected void onCreate() {
        createdDate = new Timestamp(new Date().getTime());
    }

    @PreUpdate
    protected void onUpdate() {
        updatedDate = new Timestamp(new Date().getTime());
    }



  
}
