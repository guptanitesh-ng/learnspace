package com.concepts.redis.properties;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties
public class ApplicationProperties {

    private String hostsConfig;

    private Map<String, String> cacheTTLMapping;
    
    private String realm;
    
    private Map<String, String> dynamicCacheMapping; 

    public String getHostsConfig() {
        return hostsConfig;
    }

    public void setHostsConfig(String hostsConfig) {
        this.hostsConfig = hostsConfig;
    }

	public Map<String, String> getCacheTTLMapping() {
		return cacheTTLMapping;
	}

	public void setCacheTTLMapping(Map<String, String> cacheTTLMapping) {
		this.cacheTTLMapping = cacheTTLMapping;
	}

	public String getRealm() {
		return realm;
	}

	public void setRealm(String realm) {
		this.realm = realm;
	}

	public Map<String, String> getDynamicCacheMapping() {
		return dynamicCacheMapping;
	}

	public void setDynamicCacheMapping(Map<String, String> dynamicCacheMapping) {
		this.dynamicCacheMapping = dynamicCacheMapping;
	}
    
}
