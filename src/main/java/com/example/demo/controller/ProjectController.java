package com.example.demo.controller;

import com.example.demo.entity.Project;
import com.example.demo.entity.Task;
import com.example.demo.service.ProjectService;
import com.example.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    public ProjectService projectService;


    @GetMapping("/")
    public List<Project> getAll(){
        return projectService.getAll();
    }

    @GetMapping("/{id}")
    public Project getById(@PathVariable("id") Long id){
        return projectService.getById(id);
    }

    @PostMapping("/{id}")
    public void create(@RequestBody Project project){
        projectService.createTask(project);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id){
        projectService.deleteById(id);
    }
    @PutMapping("/")
    public void updateById(@RequestBody Project project){
        projectService.updateById(project);
    }

}
