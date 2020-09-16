package com.hcid.partner.auth.dto;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by rizki.rachman02 on 10/31/2017.
 */

@Data
public class PartnerSalesroom extends BaseDto  {
    private String id;

    
    private String name;

    
    private String code;

    
    private String address;

    
    private String tippersDefault;

    
    private Partner partner;
    
    
    


}
