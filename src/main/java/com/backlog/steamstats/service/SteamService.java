package com.backlog.steamstats.service;

import com.backlog.steamstats.model.SteamAchievementsForGame;
import com.backlog.steamstats.model.SteamOwnedGamesResponse;
import com.backlog.steamstats.model.SteamPlayerAchievements;
import com.backlog.steamstats.model.SteamPlayerSummaryResponse;
import com.backlog.steamstats.properties.SteamApiProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class SteamService {
    private final RestClient steamRestClient;
    private final SteamApiProperties steamApiProperties;

    public SteamService(RestClient steamRestClient, SteamApiProperties steamApiProperties) {
        this.steamRestClient = steamRestClient;
        this.steamApiProperties = steamApiProperties;
    }

    public SteamPlayerSummaryResponse getPlayerSummary(String steamId) {
        return steamRestClient.get()
                .uri("/ISteamUser/GetPlayerSummaries/v0002/?key={key}&steamids={steamId}",
                        steamApiProperties.getKey(), steamId)
                .retrieve()
                .body(SteamPlayerSummaryResponse.class);
    }

    public SteamOwnedGamesResponse getOwnedGames(String steamId, Integer includeAppInfo, Integer includePlayedFreeGames) {
        return steamRestClient.get()
                .uri("/IPlayerService/GetOwnedGames/v0001/?key={key}&steamid={steamId}&include_appinfo={appInfo}&include_played_free_games={freegames}",
                        steamApiProperties.getKey(), steamId, includeAppInfo, includePlayedFreeGames)
                .retrieve()
                .body(SteamOwnedGamesResponse.class);
    }

    public SteamAchievementsForGame getAchievementsListForGames(int appid, String language) {
        return steamRestClient.get()
                .uri("/ISteamUserStats/GetSchemaForGame/v2/?appid={appid}&key={key}&l={language}",
                        appid, steamApiProperties.getKey(), language)
                .retrieve()
                .body(SteamAchievementsForGame.class);
    }

    public SteamPlayerAchievements getPlayerAchievements(int appid, String steamId, String language) {
        return steamRestClient.get()
                .uri("/ISteamUserStats/GetPlayerAchievements/v0001/?appid={appid}&key={key}&steamid={steamId}&l={language}",
                        appid, steamApiProperties.getKey(), steamId, language)
                .retrieve()
                .body(SteamPlayerAchievements.class);
    }
}
