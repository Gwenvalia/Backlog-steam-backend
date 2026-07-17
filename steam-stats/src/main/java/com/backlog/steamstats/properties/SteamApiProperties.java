package com.backlog.steamstats.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "steam.api")
public class SteamApiProperties {
    private String key;
    private String baseUrl;

    // getters et setters obligatoires
    public String getKey() { return key; }
    public void setKey(String key) { this.key = key; }
    public String getBaseUrl() { return baseUrl; }
    public void setBaseUrl(String baseUrl) { this.baseUrl = baseUrl; }
}
