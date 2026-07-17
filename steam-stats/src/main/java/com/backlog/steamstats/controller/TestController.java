package com.backlog.steamstats.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RestController
@RequestMapping("/api")
public class TestController {

    private final DataSource dataSource;

    public TestController(DataSource dataSource) {  // Injection par constructeur
        this.dataSource = dataSource;
    }

    @GetMapping("/")
    public String hello() {
        return "Application démarrée avec succès !";
    }

    @GetMapping("/health")
    public String health() {
        return "OK";
    }

    @GetMapping("/db-test")
    public ResponseEntity<String> testDb() {
        try (Connection conn = dataSource.getConnection()) {
            String productName = conn.getMetaData().getDatabaseProductName();
            String url = conn.getMetaData().getURL();
            return ResponseEntity.ok("✅ DB OK - " + productName + "\nURL: " + url);
        } catch (SQLException e) {
            return ResponseEntity.status(500)
                    .body("❌ Connexion DB échouée : " + e.getMessage());
        }
    }

    @GetMapping("/debug-key")
    public String debugKey() {
        String key = System.getenv("API_KEY_STEAM");
        if (key == null) return "❌ Variable d'environnement introuvable";
        return "✅ Clé trouvée, longueur: " + key.length();
    }
}
