package com.hcid.partner.auth.service;



import java.util.List;

import com.hcid.partner.auth.dto.User;
import com.hcid.partner.auth.entity.PartnerUser;




public interface UserService {
	
	List findAll();
	User findByName(String username);
	PartnerUser findUserByName(String username);
	List<PartnerUser>  getUserByEmailAndIsDelete(String email, String isDelete) throws Exception;
	List<PartnerUser>  getUserByPhoneNumberAndIsDelete(String phoneNumber, String isDelete) throws Exception;
	PartnerUser insert(PartnerUser tippersUser);
	
	

}
