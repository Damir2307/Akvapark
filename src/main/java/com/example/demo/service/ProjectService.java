package com.example.demo.service;

import com.example.demo.entity.Project;
import com.example.demo.entity.Task;
import com.example.demo.repository.ProjectRepository;
import com.example.demo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    public ProjectRepository projectRepository;

    public Project getById(Long id){
        return projectRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id){
        projectRepository.deleteById(id);
    }

    public void createTask(Project project){
        projectRepository.save(project);
    }
    public void updateById(Project project,Long id){
        Project old=projectRepository.getById(id);
        old.setName(project.getName());
        old.setStatus(project.getStatus());
        old.setPriority(project.getPriority());
        old.setStartDate(project.getStartDate());
        old.setComplDate(project.getComplDate());
        projectRepository.save(old);
    }

    public List<Project> getAll() {
        return projectRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }
}
