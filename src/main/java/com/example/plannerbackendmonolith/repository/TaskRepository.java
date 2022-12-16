//package com.example.plannerbackendmonolith.repository;
//
//import com.example.plannerbackendmonolith.model.Task;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//
//import java.util.Date;
//import java.util.List;
//
//public interface TaskRepository extends JpaRepository<Task, Long> {
//    List<Task> findByUserEmailOrderByTitleAsc(String email);
//
//
//    @Query("select t from Task t where" +
//            " (:title is null or :title = '' or lower(t.title) like (concat('%', t.title, '%'))) and " +
//            ":completed is null or :completed = t.completed and " +
//            ":categoryId is null or t.category.id = :categoryId and " +
//            ":priorityId is null or t.priority.id = :priorityId and " +
//            "t.user.email = :email and " +
//            "cast(:dateFrom as timestamp) is null or t.taskDate >= :dateFrom and " +
//            "cast(:dateFrom as timestamp) is null or t.taskDate <= :dateFrom")
//    Page<Task> findByParams(@Param("title") String title,
//                            @Param("completed") Boolean completed,
//                            @Param("categoryId") Long categoryId,
//                            @Param("priorityId") Long priorityId,
//                            @Param("email") String email,
//                            @Param("dateFrom") Date dateFrom,
//                            @Param("dateTo") Date dateTo,
//                            Pageable pageable);
//}
