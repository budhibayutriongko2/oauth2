package com.hcid.partner.auth.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcid.partner.auth.dao.ActivityLogDAO;
import com.hcid.partner.auth.dao.TippersLogDAO;
import com.hcid.partner.auth.entity.ActivityLog;
import com.hcid.partner.auth.entity.TippersLog;
import com.hcid.partner.auth.service.ActivityLogService;



/**
 * Created by andry.sunandar01 on 30/01/2018.
 */
@Service
public class ActivityLogServiceImpl implements ActivityLogService {

    @Autowired
    private ActivityLogDAO activityLogDAO;
    
    @Autowired
    private  TippersLogDAO tippersLogDAO;


	@Override
	public ActivityLog getLogByCode(String code) {
		return activityLogDAO.findFirstByCode(code);
	}
	

	@Override
	public TippersLog activityCreatedBy(String createdBy) {
		
		return tippersLogDAO.findFirstByTippersLogChildCreatedByOrderByTippersLogChildCreatedDateDesc(createdBy);
	}
	
	
	

	
}
