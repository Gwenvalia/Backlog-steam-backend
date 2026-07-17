package com.backlog.steamstats.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SteamPlayerAchievements(PlayerStats playerstats) {

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record PlayerStats(List<Achievements> achievements) {}

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Achievements (
            @JsonProperty("apiname") String apiName,
            @JsonProperty("achieved") boolean achieved,
            @JsonProperty("unlocktime") long unlockTime,
            @JsonProperty("name") String name,
            @JsonProperty("description") String description
    ) {}
}
