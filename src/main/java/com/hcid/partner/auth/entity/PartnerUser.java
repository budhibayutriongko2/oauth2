package com.hcid.partner.auth.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;


import com.fasterxml.jackson.annotation.JsonProperty;



import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;



@Data
@Entity
@Table(name = "TP_USER")
@DynamicUpdate
public class PartnerUser  implements Serializable {

    
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "ID")
    private String id;

    
    @Column(name = "USERNAME")
    private String username;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "PASSWORD")
    private String pass;


    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "CREATED_DATE",updatable = false)
    private Date createdDate;

    @Column(name = "CREATED_BY",updatable = false)
    private String createdBy;

    @Column(name = "UPDATED_DATE")
    private Date updatedDate;

    @Column(name = "UPDATED_BY")
    private String updatedBy;

    @Column(name = "IS_DELETE")
    private String isDelete;

    @Column(name = "FIRST_NAME")
    private String firstName;


    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "EMPLOYEE_CODE")
    private String employeeCode;

    @Column(name = "STATUS_CODE")
    private String partnerStatus;


    @Column(name = "KTP_NUMBER")
    private String ktpNumber;
    
    /* tippers start */
    @Column(name = "NPWP_NUMBER")
    private String npwpNumber;
    
    @Column(name = "BANK_CODE")
    private String bankCode;
    
    @Column(name = "NPWP_ADDRESS")
    private String npwpAddress;
    
    @Column(name = "ACCOUNT_NUMBER")
    private String accountNumber;

    @Column(name = "ACCOUNT_NAME")
    private String accountName;

    
    @Column(name = "PROMOTOR")
    private String promotor;
    
    @Column(name = "IS_SELF_REGIST")
    private String isSelfRegist;
    
    @Column(name = "RESET_FLAG")
    private Integer resetFlag;
    
    
    @Column(name = "OTP_NUMBER")
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
