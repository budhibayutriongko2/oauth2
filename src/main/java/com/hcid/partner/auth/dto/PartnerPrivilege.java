package com.hcid.partner.auth.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Collection;

/**
 * Created by andry.sunandar01 on 07/04/2018.
 */
@Data
public class PartnerPrivilege  {

    
    private String id;

    
    private String privilegeId;

   
    private String name;

    
    private String isDelete;

    @JsonIgnore
    private Collection<PartnerRole> roles;

}
