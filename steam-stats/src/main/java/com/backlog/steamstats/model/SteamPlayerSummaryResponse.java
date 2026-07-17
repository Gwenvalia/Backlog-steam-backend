package com.backlog.steamstats.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SteamPlayerSummaryResponse(Response response) {

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Response(List<Player> players) {}

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Player(
            @JsonProperty("steamid") String steamId,
            @JsonProperty("personaname") String personaName,
            @JsonProperty("avatarfull") String avatarFullUrl
    ) {}
}
