package com.example.plannerbackendmonolith.repository;

import com.example.plannerbackendmonolith.model.Stat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatRepository extends JpaRepository<Stat, Long> {

    Stat findByUserEmail(String email);
}
