package com.concepts.finance;

import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationProperties {

    private String hostsConfig;

    private String realm;

    public String getHostsConfig() {
        return hostsConfig;
    }

    public void setHostsConfig(String hostsConfig) {
        this.hostsConfig = hostsConfig;
    }

    public String getRealm() {
        return realm;
    }

    public void setRealm(String realm) {
        this.realm = realm;
    }

}
