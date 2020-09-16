package com.hcid.partner.auth.config;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;


@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	
	@Autowired
    private TokenStore tokenStore;

    @Autowired
    private AuthenticationManager authenticationManager;


	    @Autowired
	    private DataSource dataSource;



	   
	   @Override
		public void configure(ClientDetailsServiceConfigurer configurer) throws Exception {
			configurer.jdbc(dataSource);

		}
	   
	   @Override
	   public void configure(final AuthorizationServerEndpointsConfigurer endpoints) {
	       endpoints
	       .tokenStore(tokenStore)
	               .authenticationManager(authenticationManager);
	   }


	
	

}