package com.example.demo.controller;

import com.example.demo.entity.Project;
import com.example.demo.entity.Task;
import com.example.demo.service.ProjectService;
import com.example.demo.service.TaskService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "Project controller")
@CrossOrigin
@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    public ProjectService projectService;

    @ApiOperation(value = "get all projects",notes = "get all projects")
    @GetMapping("/List")
    public List<Project> getAll(){
        return projectService.getAll();
    }

    @ApiOperation(value = "get Project",notes = "get Project")
    @GetMapping("/{id}")
    public Project getById(@PathVariable("id") Long id){
        return projectService.getById(id);
    }

    @ApiOperation(value = "create Project",notes = "create Project")
    @PostMapping("/create")
    public void create(@RequestBody Project project){
        projectService.createTask(project);
    }

    @ApiOperation(value = "delete Project",notes = "delete Project")
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id){
        projectService.deleteById(id);
    }

    @ApiOperation(value = "update Project",notes = "update Project")
    @PutMapping("/{id}")
    public void updateById(@RequestBody Project project,@PathVariable Long id){
        projectService.updateById(project,id);
    }

}
