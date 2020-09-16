package com.hcid.partner.auth.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by yusep.maulana07 on 11/06/2019.
 */
@Data
@Embeddable
public class TippersLogChild  implements Serializable {

   
	private static final long serialVersionUID = 1353203053723784390L;

	
    @Column(name = "ACTIVITY_CODE")
    private String activityCode;

    @Column(name = "VALUE")
    private String value;
    
    @Column(name = "STATUS")
    private String status;
    
    @Column(name = "CREATED_DATE")
    private Date createdDate;

    @Column(name = "CREATED_BY")
    private String createdBy;

    
    @PrePersist
    protected void onCreate() {
        createdDate = new Timestamp(new Date().getTime());
    }

  
}
