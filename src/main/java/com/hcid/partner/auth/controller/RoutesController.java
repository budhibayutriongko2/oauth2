package com.hcid.partner.auth.controller;

import java.security.Principal;
import java.util.Map;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcid.partner.auth.config.GeneralConfig;
import com.hcid.partner.auth.entity.PartnerUser;
import com.hcid.partner.auth.service.UserService;
import com.hcid.partner.auth.utility.ConnectorUtil;

import javax.servlet.http.HttpServletRequest;


/**
 * BBT
 */
@RestController
@RequestMapping(value = "/routes")
public class RoutesController {

	
	@Autowired
	UserService userService;
	
	@Autowired
	GeneralConfig config;
	
	@RequestMapping(value = "/postApi", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public ResponseEntity postApi(@RequestBody Map<String, Object> request, Principal principal, HttpServletRequest httpServletRequest) {
    	PartnerUser partnerUser = null;
		partnerUser = userService.findUserByName(principal.getName());
		request.put("partnerUser", partnerUser);
		request.put("activity", "Y"); 
		ResponseEntity response = null;
		if (request.get("get") == null ){
			response = ConnectorUtil.postD(config.getUrlEnvironment().concat(request.get("api").toString()), request);
		}else{
			response = ConnectorUtil.getD(config.getUrlEnvironment().concat(request.get("api").toString()), request);
		}
		
		return response;
    	
       
    }
}

enum HTTP_METHOD
{
	GET,POST
}
