package com.example.plannerbackendmonolith.service;

import com.example.plannerbackendmonolith.model.Category;
import com.example.plannerbackendmonolith.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findAllCategory(String email) {
        return categoryRepository.findByUserEmailOrderByTitleAsc(email);
    }

    @Transactional
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Transactional
    public Category updateCategory(Category category) {
        return categoryRepository.save(category);
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    public List<Category> search(String title, String email) {
        return categoryRepository.findByTitle(title, email);
    }
}
