package com.DinoData.DinoData.health;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/health")
public class HealthController {

    @GetMapping
    public ResponseEntity<Map<String, Object>> health() {
        return ResponseEntity.ok(
                Map.of(
                        "status", "OK",
                        "service", "dino-backend",
                        "version", "0.0.1"
                )
        );
    }
}
