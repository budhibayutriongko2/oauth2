package com.hcid.partner.auth.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.endpoint.Endpoint;
import org.springframework.stereotype.Component;

@Component
public class VersionController implements Endpoint {

    //@Value("${app.version}")
    private String appVersion;

    @Override
    public String getId() {
        return "get-version";
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean isSensitive() {
        return false;
    }

    @Override
    public Object invoke() {
        return appVersion;
    }
}
