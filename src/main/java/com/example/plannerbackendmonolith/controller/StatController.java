package com.example.plannerbackendmonolith.controller;

import com.example.plannerbackendmonolith.model.Stat;
import com.example.plannerbackendmonolith.service.StatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatController {

    private StatService statService;

    public StatController(StatService statService) {
        this.statService = statService;
    }

    @PostMapping("/stat")
    public ResponseEntity<Stat> getStat(@RequestBody String email) {
        return ResponseEntity.ok(statService.findByUserEmail(email));
    }
}
