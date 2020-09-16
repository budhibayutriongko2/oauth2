package com.hcid.partner.auth.service;

import com.hcid.partner.auth.entity.ActivityLog;
import com.hcid.partner.auth.entity.TippersLog;

public interface ActivityLogService {
	
	ActivityLog getLogByCode(String code);
	TippersLog activityCreatedBy (String createdBy);

}
