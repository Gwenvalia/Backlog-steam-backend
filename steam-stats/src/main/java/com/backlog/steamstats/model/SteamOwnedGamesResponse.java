package com.backlog.steamstats.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SteamOwnedGamesResponse (Response response ){

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Response(
        @JsonProperty("game_count") int gameCount,
        @JsonProperty("games") List<Game> games,
        @JsonProperty("private") Boolean isPrivate
    ) {}

    @JsonIgnoreProperties(ignoreUnknown = true)
    public record Game(
        @JsonProperty("appid") int appid,
        @JsonProperty("name") String name,
        @JsonProperty("playtime_forever") int playtimeForever,
        @JsonProperty("rtime_last_played") int timeLastPlayed,
        @JsonProperty("img_icon_url") String imgIconUrl,
        @JsonProperty("has_community_visible_stats") Boolean hasCommunityVisibleStats
    ) {}
}
