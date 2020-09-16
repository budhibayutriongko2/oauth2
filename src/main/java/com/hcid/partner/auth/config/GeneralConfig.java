package com.hcid.partner.auth.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


/**
 * Created by andry.sunandar01 on 09/02/2018.
 */
@Data
@Component
@ConfigurationProperties(prefix="generalConfig")
@PropertySource("file:/file/tippers/auth.properties")
public class GeneralConfig {

    private String baseTempPath;
    private String baseFileTmp;
    private int tokenExpireTime;
    private String aldiUser;
    private String istUser;
    private String oasysUser;
    private int hashMode;
    private String surveyIdA;
    private String surveyIdB;
    private String surveyIdC;
    private String urlEnvironment;
    private String surveyToken;
    private int restConnectTimeout;
    private int restReadTimeout;
    
    
    private String dokuUrl;
    private String dokuMallId;
    private String dokuSharedKey;

}
