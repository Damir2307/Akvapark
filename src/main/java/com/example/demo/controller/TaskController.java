package com.example.demo.controller;

import com.example.demo.entity.Task;
import com.example.demo.service.TaskService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "Task controller")
@CrossOrigin
@RestController
@RequestMapping("/api/task")
public class TaskController {
    @Autowired
    public TaskService taskService;

    @ApiOperation(value = "get Task",notes = "get Task")
    @GetMapping("/{id}")
    public Task getById(@PathVariable("id") Long id){
        return taskService.getById(id);
    }

    @ApiOperation(value = "Create task",notes = "Create task")
    @PostMapping("/create")
    public void create(@RequestBody Task task){
        taskService.createTask(task);
    }

    @ApiOperation(value = "Delete task",notes = "Delete task")
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id){
        taskService.deleteById(id);
    }

    @ApiOperation(value = "Update task",notes = "Update task")
    @PutMapping("/{id}")
    public void updateById(@RequestBody Task task,@PathVariable Long id){
        taskService.updateById(task,id);
    }

    @ApiOperation(value = "Get list of tasks from project",notes = "Get list of tasks from project")
    @GetMapping("/project/{id}")
    public List<Task> getTasksFromProjectId(@PathVariable("id") Long id){
        return taskService.getTasks(id);
    }

}
