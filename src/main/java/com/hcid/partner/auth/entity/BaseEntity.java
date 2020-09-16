package com.hcid.partner.auth.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Column;
import java.util.Date;

/**
 * Created by andry.sunandar01 on 05/04/2018.
 */
@Data
public abstract class BaseEntity {

    @Column(name = "CREATED_DATE",updatable = false)
    private Date createdDate;

    @JsonIgnore
    @Column(name = "CREATED_BY")
    private String createdBy;

   
}
