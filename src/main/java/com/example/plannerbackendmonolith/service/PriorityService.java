package com.example.plannerbackendmonolith.service;

import com.example.plannerbackendmonolith.model.Priority;
import com.example.plannerbackendmonolith.repository.PriorityRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class PriorityService {

    private PriorityRepository priorityRepository;

    public PriorityService(PriorityRepository priorityRepository) {
        this.priorityRepository = priorityRepository;
    }


    public List<Priority> findPriorityByUserEmail(String email) {
        return priorityRepository.findByUserEmailOrderByTitleAsc(email);
    }

    @Transactional
    public Priority addPriority(Priority priority) {
        return priorityRepository.save(priority);
    }

    @Transactional
    public Priority updatePriority(Priority priority) {
        return priorityRepository.save(priority);
    }

    public void deletePriority(Long id) {
        priorityRepository.deleteById(id);
    }

    public List<Priority> search(String title, String email) {
        return priorityRepository.findByTitle(title, email);
    }
}
