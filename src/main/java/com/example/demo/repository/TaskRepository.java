package com.example.demo.repository;

import com.example.demo.entity.Task;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepositoryImplementation<Task, Long> {
    @Query("select t from Task t where t.project.id=?1")
    List<Task> getTasks(Long id);


}
