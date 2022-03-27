package com.example.demo.repository;

import com.example.demo.entity.Project;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepositoryImplementation<Project, Long> {
}
