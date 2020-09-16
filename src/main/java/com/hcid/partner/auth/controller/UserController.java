package com.hcid.partner.auth.controller;


import com.hcid.partner.auth.config.EndpointConfig;
import com.hcid.partner.auth.dto.User;
import com.hcid.partner.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;



@RestController
@RequestMapping("/api")
@EnableResourceServer
public class UserController {


		
	
    @Autowired
    private UserService userService;
    @Autowired
    private EndpointConfig endpointConfig;

    @RequestMapping(value="/user", method = RequestMethod.GET)
    public List listUser(Principal principal){
    	
        return userService.findAll();
    }
    @RequestMapping(value="/user2", method = RequestMethod.GET)
    public List listUser2(){
        return userService.findAll();
    }
    
    @RequestMapping(value="/getUserData", method = RequestMethod.GET)
    public User getUserData(Principal principal){
        return userService.findByName(principal.getName());
    }
    
    
       
}