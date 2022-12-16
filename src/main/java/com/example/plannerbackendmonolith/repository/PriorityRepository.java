package com.example.plannerbackendmonolith.repository;

import com.example.plannerbackendmonolith.model.Priority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PriorityRepository extends JpaRepository<Priority, Long> {

    List<Priority> findByUserEmailOrderByTitleAsc(String email);

    @Query("select p from Priority p where " +
            "(:title is null or :title = '' or lower(p.title) like (concat('%', :titile, '%'))) " +
            "and p.user.email = :email order by p.title asc ")
    List<Priority> findByTitle(@Param("title") String title, @Param("email") String email);
}
