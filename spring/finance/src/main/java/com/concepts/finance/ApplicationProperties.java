package com.concepts.finance;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource({ "classpath*:clu-dal-admin-redis_context.xml" })
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
