package com.backlog.steamstats.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "steam.api")
public class SteamApiProperties {
    private String key;
    private String baseUrl;
}
