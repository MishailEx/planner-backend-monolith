package com.example.plannerbackendmonolith.service;

import com.example.plannerbackendmonolith.model.Stat;
import com.example.plannerbackendmonolith.repository.StatRepository;
import org.springframework.stereotype.Service;

@Service
public class StatService {

    private StatRepository statRepository;

    public StatService(StatRepository statRepository) {
        this.statRepository = statRepository;
    }

    public Stat findByUserEmail(String email) {
        return statRepository.findByUserEmail(email);
    }
}
