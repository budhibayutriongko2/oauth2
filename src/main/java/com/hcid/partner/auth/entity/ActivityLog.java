package com.hcid.partner.auth.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by yusep.maulana07 on 11/06/2019.
 */
@Data
@Entity
@Table(name = "TP_ACTIVITY_ID")
@DynamicUpdate
public class ActivityLog  implements Serializable {

    @Id
    @Column(name = "CODE")
    private String code;

    @Column(name = "NAME")
    private String name;
    
    @Column(name = "STATUS")
    private String status;
    
    @Column(name = "ACTIVITY_GROUP_CODE")
    private String activityGroupCode;
    
    @Column(name = "IS_DELETE")
    private String isDelete;

    @Column(name = "CREATED_DATE")
    private Date createdDate;

    @Column(name = "CREATED_BY")
    private String createdBy;

    @Column(name = "UPDATED_DATE")
    private Date updatedDate;

    @Column(name = "UPDATED_BY")
    private String updatedBy;

    @PrePersist
    protected void onCreate() {
        createdDate = new Timestamp(new Date().getTime());
    }

    @PreUpdate
    protected void onUpdate() {
        updatedDate = new Timestamp(new Date().getTime());
    }
}
