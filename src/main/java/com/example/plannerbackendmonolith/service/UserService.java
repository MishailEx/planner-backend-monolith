package com.example.plannerbackendmonolith.service;

import com.example.plannerbackendmonolith.model.User;
import com.example.plannerbackendmonolith.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public User addUser(User user) {
        return userRepository.save(user);
    }
}
