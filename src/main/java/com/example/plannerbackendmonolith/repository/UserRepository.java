package com.example.plannerbackendmonolith.repository;

import com.example.plannerbackendmonolith.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
