package com.hcid.partner.auth.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcid.partner.auth.entity.ActivityLog;





/**
 * Created by andry.sunandar01 on 30/01/2018.
 */
@Repository
public interface ActivityLogDAO extends JpaRepository<ActivityLog,String> {


    ActivityLog findFirstByCode(String code);
    ActivityLog findFirstByCreatedByOrderByCreatedDateDesc(String phoneNumber);
    

}
