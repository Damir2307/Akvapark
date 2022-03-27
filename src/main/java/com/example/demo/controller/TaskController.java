package com.example.demo.controller;

import com.example.demo.entity.Task;
import com.example.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/task")
public class TaskController {
    @Autowired
    public TaskService taskService;

    @GetMapping("/{id}")
    public Task getById(@PathVariable("id") Long id){
        return taskService.getById(id);
    }

    @PostMapping("/{id}")
    public void create(@RequestBody Task task,@PathVariable Long id){
        taskService.createTask(task,id);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id){
        taskService.deleteById(id);
    }
    @PutMapping("/")
    public void updateById(@RequestBody Task task){
        taskService.updateById(task);
    }
    @GetMapping("/{id}")
    public List<Task> getTasksFromProjectId(@PathVariable("id") Long id){
        return taskService.getTasks(id);
    }

}
