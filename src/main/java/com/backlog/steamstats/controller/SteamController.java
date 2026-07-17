package com.backlog.steamstats.controller;

import com.backlog.steamstats.model.SteamAchievementsForGame;
import com.backlog.steamstats.model.SteamOwnedGamesResponse;
import com.backlog.steamstats.model.SteamPlayerAchievements;
import com.backlog.steamstats.model.SteamPlayerSummaryResponse;
import com.backlog.steamstats.service.SteamService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/steam")
public class SteamController {

    private final SteamService steamService;

    private SteamController (SteamService steamService) {
        this.steamService = steamService;
    }

    @GetMapping("/player/{steamId}")
    public ResponseEntity<SteamPlayerSummaryResponse> playerInfo(@PathVariable String steamId) {
        return ResponseEntity.ok(steamService.getPlayerSummary(steamId));
    }

    @GetMapping("/owned/{steamId}/{appInfo}/{freeGames}")
    public ResponseEntity<SteamOwnedGamesResponse> ownedGames(
            @PathVariable String steamId,
            @PathVariable Integer appInfo,
            @PathVariable Integer freeGames
    ) {
        return ResponseEntity.ok(steamService.getOwnedGames(steamId, appInfo, freeGames));
    }

    @GetMapping("/schema/{appid}/{language}")
    public ResponseEntity<SteamAchievementsForGame> listAchievementsTotal(
            @PathVariable int appid,
            @PathVariable String language
    ) {
        return ResponseEntity.ok(steamService.getAchievementsListForGames(appid, language));
    }

    @GetMapping("/achievements/{appid}/{steamId}/{language}")
    public  ResponseEntity<SteamPlayerAchievements> listPlayerAchievements(
            @PathVariable int appid,
            @PathVariable String steamId,
            @PathVariable String language
    ) {
        return ResponseEntity.ok(steamService.getPlayerAchievements(appid, steamId, language));
    }
}
