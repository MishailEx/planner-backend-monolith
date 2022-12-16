package com.example.plannerbackendmonolith.repository;

import com.example.plannerbackendmonolith.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findByUserEmailOrderByTitleAsc(String email);

    @Query("select c from Category c where " +
            "(:title is null or :title = '' or lower(c.title) like (concat('%', :title, '%')))" +
            "and c.user.email = :email order by c.title asc")
    List<Category> findByTitle(@Param("title") String title, @Param("email") String email);

}
