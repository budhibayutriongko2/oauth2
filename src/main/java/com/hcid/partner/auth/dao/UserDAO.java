package com.hcid.partner.auth.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcid.partner.auth.entity.PartnerUser;



/**
 * Created by andry.sunandar01 on 30/01/2018.
 */
@Repository
public interface UserDAO extends JpaRepository<PartnerUser,String> {

	PartnerUser findByUsernameAndPassAndIsDeleteAndPartnerStatus(String username, String pass, String isDelete, String status);
	PartnerUser findByEmailAndPassAndIsDeleteAndPartnerStatus(String email, String pass, String isDelete, String status);
	PartnerUser findByPhoneNumberAndPassAndIsDeleteAndPartnerStatus(String phoneNumber, String pass, String isDelete, String status);
	PartnerUser findByUsernameAndPass(String username, String pass);
	PartnerUser findByEmailAndPass(String email, String pass);
	PartnerUser findByPhoneNumberAndPass(String phoneNumber, String pass);
	PartnerUser findByUsername(String username);
	PartnerUser findByEmail(String email);
	PartnerUser findByPhoneNumber(String phoneNumber);
	PartnerUser findByUsernameAndIsDeleteAndPartnerStatus(String username, String isDelete, String status);
	PartnerUser findByEmailAndIsDeleteAndPartnerStatus(String email, String isDelete, String status);
	PartnerUser findByPhoneNumberAndIsDeleteAndPartnerStatus(String phoneNumber, String isDelete, String status);
	List<PartnerUser> findByEmailIgnoreCaseAndIsDelete (String email, String isDelete);
	List<PartnerUser> findByPhoneNumberIgnoreCaseAndIsDelete (String phoneNumber, String isDelete);
    
    

}
