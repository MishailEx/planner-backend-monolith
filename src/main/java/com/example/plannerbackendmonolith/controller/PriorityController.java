package com.example.plannerbackendmonolith.controller;

import com.example.plannerbackendmonolith.model.Priority;
import com.example.plannerbackendmonolith.search.PrioritySearch;
import com.example.plannerbackendmonolith.service.PriorityService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/priority")
public class PriorityController {

    private PriorityService priorityService;

    public PriorityController(PriorityService priorityService) {
        this.priorityService = priorityService;
    }

    @PostMapping("/all")
    public ResponseEntity<List<Priority>> findAll(@RequestBody String email) {
        return new ResponseEntity(priorityService.findPriorityByUserEmail(email), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Priority> add(@Valid @RequestBody Priority priority) {
        if (priority.getId() != null && priority.getId() != 0) {
            return new ResponseEntity("id must be empty", HttpStatus.NOT_ACCEPTABLE);
        }
        return ResponseEntity.ok(priorityService.addPriority(priority));
    }

    @PostMapping("/update")
    public ResponseEntity<Priority> update(@Valid @RequestBody Priority priority) {
        if (priority.getId() == null || priority.getId() == 0) {
            return new ResponseEntity("id must be not empty", HttpStatus.NOT_ACCEPTABLE);
        }
        priorityService.addPriority(priority);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        priorityService.deletePriority(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/search")
    public ResponseEntity search(@RequestBody PrioritySearch prioritySearch) {
        if (prioritySearch.getEmail() == null || prioritySearch.getEmail().trim().length() == 0) {
            return new ResponseEntity("email must be not empty", HttpStatus.NOT_ACCEPTABLE);
        }
        List<Priority> list = priorityService.search(prioritySearch.getTitle(), prioritySearch.getEmail());
        return ResponseEntity.ok(list);
    }
}
