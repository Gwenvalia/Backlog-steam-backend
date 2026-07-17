package com.backlog.steamstats.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SteamAchievementsForGame(Game game) {

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Game (
        @JsonProperty("gameName") String gameName,
        @JsonProperty("availableGameStats") AvailableGameStats availableGameStats
    ) {}

    @JsonIgnoreProperties(ignoreUnknown = true)
    private record AvailableGameStats (
        @JsonProperty("achievements") List<Achievements> achievements
    ) {}

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Achievements (
        @JsonProperty("name") String name,
        @JsonProperty("displayName") String displayName,
        @JsonProperty("description") String description,
        @JsonProperty("hidden") Boolean hidden,
        @JsonProperty("icon") String icon,
        @JsonProperty("icongray") String iconGray
    ) {}
}
