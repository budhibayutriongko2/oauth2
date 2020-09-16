package com.hcid.partner.auth.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;



/**
 * Created by yusep.maulana07 on 15/02/2019.
 */

@Configuration
@PropertySource("file:/file/tippers/auth.properties")
public class ExternalConfig {

	 private GeneralConfig generalConfig;

	    @Autowired
	    public ExternalConfig(GeneralConfig generalConfig) {this.generalConfig = generalConfig;}

	    public GeneralConfig getGeneralConfig() {
	        return generalConfig;
	    }

	    public void setGeneralConfig(GeneralConfig generalConfig) {
	        this.generalConfig = generalConfig;
	    }
}
