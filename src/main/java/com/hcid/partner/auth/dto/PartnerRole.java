package com.hcid.partner.auth.dto;

import lombok.Data;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created by rizki.rachman02 on 10/31/2017.
 */

@Data
public class PartnerRole {

   
    private String id;


    private String roleId;


    private String roleName;


    private Collection<PartnerPrivilege> privileges;


    private String isDelete;


    private String roleCodeSmart;
    
 
    private String isSmart;
    
   

}
