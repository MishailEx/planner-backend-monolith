package com.example.plannerbackendmonolith.controller;

import com.example.plannerbackendmonolith.model.Category;
import com.example.plannerbackendmonolith.search.CategorySearch;
import com.example.plannerbackendmonolith.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/add")
    public ResponseEntity<Category> add(@Valid @RequestBody Category category) {
        if (category.getId() != null && category.getId() != 0) {
            return new ResponseEntity("id must be null", HttpStatus.NOT_ACCEPTABLE);
        }
        return ResponseEntity.ok(categoryService.addCategory(category));
    }

    @PostMapping("/update")
    public ResponseEntity<Category> update(@Valid @RequestBody Category category) {
        if (category.getId() == null || category.getId() == 0) {
            return new ResponseEntity("id must be not null", HttpStatus.NOT_ACCEPTABLE);
        }
        categoryService.addCategory(category);
        return ResponseEntity.ok(category);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Category>> findAll(@RequestBody String email) {
        return new ResponseEntity(categoryService.findAllCategory(email), HttpStatus.OK);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        categoryService.deleteCategory(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/search")
    public ResponseEntity<List<Category>> search(@RequestBody CategorySearch categorySearch) {
        if (categorySearch.getEmail() == null || categorySearch.getEmail().trim().length() == 0) {
            return new ResponseEntity("email must be not empty", HttpStatus.NOT_ACCEPTABLE);
        }
        List<Category> list = categoryService.search(categorySearch.getTitle(), categorySearch.getEmail());
        return ResponseEntity.ok(list);
    }
}
