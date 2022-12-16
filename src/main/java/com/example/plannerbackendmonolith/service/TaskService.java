//package com.example.plannerbackendmonolith.service;
//
//import com.example.plannerbackendmonolith.model.Task;
//import com.example.plannerbackendmonolith.repository.TaskRepository;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
//@Service
//@Transactional(readOnly = true)
//public class TaskService {
//    private TaskRepository taskRepository;
//
//    public TaskService(TaskRepository taskRepository) {
//        this.taskRepository = taskRepository;
//    }
//
//    public List<Task> findAllByEmail(String email) {
//        return taskRepository.findByUserEmailOrderByTitleAsc(email);
//    }
//
//    @Transactional
//    public Task addTask(Task task) {
//       return taskRepository.save(task);
//    }
//
//    @Transactional
//    public void updateTask(Task task) {
//        taskRepository.save(task);
//    }
//
//    public void deleteTask(Long id) {
//        taskRepository.deleteById(id);
//    }
//}
