package com.backlog.steamstats.config;

import com.backlog.steamstats.properties.SteamApiProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class SteamConfig {
    @Bean
    public RestClient steamRestClient(SteamApiProperties steamApiProperties) {
        return RestClient.builder()
                .baseUrl(steamApiProperties.getBaseUrl())
                .build();
    }
}
