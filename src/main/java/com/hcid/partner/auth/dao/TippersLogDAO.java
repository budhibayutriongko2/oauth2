package com.hcid.partner.auth.dao;



import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcid.partner.auth.entity.TippersLog;





/**
 * Created by andry.sunandar01 on 30/01/2018.
 */
@Repository
@Transactional
public interface TippersLogDAO extends JpaRepository<TippersLog,String> {


    TippersLog findFirstByTippersLogChildCreatedByOrderByTippersLogChildCreatedDateDesc (String createdBy);
    TippersLog findFirstByTippersLogChildCreatedByAndTippersLogChildActivityCodeOrderByTippersLogChildCreatedDateDesc (String createdBy, String activityCode);
    

}
