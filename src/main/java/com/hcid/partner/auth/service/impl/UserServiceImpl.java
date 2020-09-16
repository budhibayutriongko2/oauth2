package com.hcid.partner.auth.service.impl;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.hcid.partner.auth.config.EndpointConfig;
import com.hcid.partner.auth.dao.ActivityLogDAO;
import com.hcid.partner.auth.dao.TippersLogDAO;
import com.hcid.partner.auth.dao.UserDAO;
import com.hcid.partner.auth.dto.User;
import com.hcid.partner.auth.entity.ActivityLog;
import com.hcid.partner.auth.entity.PartnerUser;
import com.hcid.partner.auth.entity.TippersLog;
import com.hcid.partner.auth.service.UserService;
import com.hcid.partner.auth.utility.ConnectorUtil;
import com.hcid.partner.auth.utility.HelperUtil;



@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService, UserService {
	String numericRegex = "\\d+";
	
	@Autowired
	private UserDAO userDao;
	
	@Autowired
	private ActivityLogDAO activityLogDAO;
	
	@Autowired
	private TippersLogDAO tippersLogDAO;
	

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		PartnerUser user = null;
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	    String pass = request.getParameter("password");
		try {
			
			String passEncrypt = HelperUtil.generateMD5(pass);
			
			if(username.contains("@")) {
				user = userDao.findByEmailAndPassAndIsDeleteAndPartnerStatus(username, passEncrypt, "N","STATUS_USR_ACTIVE");
			}else if(username.matches(numericRegex)) {
				user = userDao.findByPhoneNumberAndPassAndIsDeleteAndPartnerStatus(username, passEncrypt, "N","STATUS_USR_ACTIVE");
				if(user == null) {
					user = userDao.findByUsernameAndPassAndIsDeleteAndPartnerStatus(username, passEncrypt, "N","STATUS_USR_ACTIVE");
				}
			}else {
				user = userDao.findByUsernameAndPassAndIsDeleteAndPartnerStatus(username, passEncrypt, "N","STATUS_USR_ACTIVE");
			
			}
			
			
			if(user == null){
				throw new UsernameNotFoundException("Invalid username or password.");
			}
		} catch (Exception e) {
			
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), pass, getAuthority());
	}

	private List getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}

	public List findAll() {
		List list = new ArrayList<>();
		userDao.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

	@Override
	//Khusus di Auth All Logic ke service activity di taro disini biar gak berat waktu login  
	public User findByName(String username) {
		PartnerUser user = null;
		User userDto = new User();
		try {
			
			if(username.contains("@")) {
				user = userDao.findByEmailAndIsDeleteAndPartnerStatus(username, "N","STATUS_USR_ACTIVE");
			}else if(username.matches(numericRegex)) {
				user = userDao.findByPhoneNumberAndIsDeleteAndPartnerStatus(username, "N","STATUS_USR_ACTIVE");
				if(user == null) {
					user = userDao.findByUsernameAndIsDeleteAndPartnerStatus(username, "N","STATUS_USR_ACTIVE");
				}
			}else {
				user = userDao.findByUsernameAndIsDeleteAndPartnerStatus(username, "N","STATUS_USR_ACTIVE");
			
			}
			
			if(user != null) {
				BeanUtils.copyProperties(user,userDto);
				if("Y".equals(user.getIsDelete())) {
					userDto.setDeactivateDate(user.getUpdatedDate());
				}
				
				
				TippersLog tnc = tippersLogDAO.findFirstByTippersLogChildCreatedByAndTippersLogChildActivityCodeOrderByTippersLogChildCreatedDateDesc(user.getPhoneNumber(),"TIPPERS_TNC");
				if(tnc != null && tnc.getTippersLogChild() != null) {
					userDto.setTncDate(tnc.getTippersLogChild().getCreatedDate());
				}
				tnc = null;
				
				TippersLog coc = tippersLogDAO.findFirstByTippersLogChildCreatedByAndTippersLogChildActivityCodeOrderByTippersLogChildCreatedDateDesc(user.getPhoneNumber(),"TIPPERS_COC");
				if(coc != null && coc.getTippersLogChild() != null) {
					userDto.setCocDate(coc.getTippersLogChild().getCreatedDate());
				}
				coc = null;
				
				
				if( "STATUS_USR_ACTIVE".equals(user.getPartnerStatus())) {
					userDto.setTippersStatus("STATUS_TIPPERS_ACTIVE");
					
				}else{
					if("N".equals(user.getIsSelfRegist()) && "STATUS_USR_INACTIVE".equals(user.getPartnerStatus()) ) {
						userDto.setTippersStatus("NOT_INITIATED");
						//cek ke tab le tp activity berdasarkan phone-number
						//Map<String, Object> data = ConnectorUtil.postC(endpointConfig.getUrlEnvironment() + endpointConfig.getActivityContextRoot() + "api/"+endpointConfig.getActivityCreatedBy(), param);
						// kalo dia empty set tippers status = NOT_INITIATED
						// Kalo dia ada set tippers status = activity code yg paling terakhir order by created date desc
						TippersLog data = tippersLogDAO.findFirstByTippersLogChildCreatedByOrderByTippersLogChildCreatedDateDesc(user.getPhoneNumber());
						
						if(data != null) {
							userDto.setTippersStatus(data.getTippersLogChild().getActivityCode());
						}
						data = null;
					}
					
					
				}
				
			}
			
		} catch (Exception e) {
			
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return userDto;
	}
	
	
	@Override
	public PartnerUser findUserByName(String username) {
		PartnerUser user = null;
		User userDto = new User();
		try {
			
			if(username.contains("@")) {
				user = userDao.findByEmailAndIsDeleteAndPartnerStatus(username, "N","STATUS_USR_ACTIVE");
			}else if(username.matches(numericRegex)) {
				user = userDao.findByPhoneNumberAndIsDeleteAndPartnerStatus(username, "N","STATUS_USR_ACTIVE");
				if(user == null) {
					user = userDao.findByUsernameAndIsDeleteAndPartnerStatus(username, "N","STATUS_USR_ACTIVE");
				}
			}else {
				user = userDao.findByUsernameAndIsDeleteAndPartnerStatus(username, "N","STATUS_USR_ACTIVE");
			
			}
			
			
			
		} catch (Exception e) {
			
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return user;
	}

	@Override
    public List<PartnerUser> getUserByEmailAndIsDelete(String email, String isDelete) {
        return userDao.findByEmailIgnoreCaseAndIsDelete(email,isDelete);
    }

	@Override
	public List<PartnerUser> getUserByPhoneNumberAndIsDelete(String phoneNumber, String isDelete) {
	     return userDao.findByPhoneNumberIgnoreCaseAndIsDelete(phoneNumber,isDelete);
	}

	@Override
	public PartnerUser insert(PartnerUser user) {
		 return userDao.saveAndFlush(user);
	}
	
}
