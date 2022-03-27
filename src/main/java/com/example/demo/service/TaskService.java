package com.example.demo.service;

import com.example.demo.entity.Task;
import com.example.demo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private ProjectService projectService;

    public Task getById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }

    public void createTask(Task task) {
        taskRepository.save(task);
    }

    public void updateById(Task task, Long id) {
        Task old = taskRepository.getById(id);
        old.setDescription(task.getDescription());
        old.setName(task.getName());
        old.setStatus(task.getStatus());
        old.setPriority(task.getPriority());
        taskRepository.save(old);
    }

    public List<Task> getTasks(Long id) {
        return taskRepository.getTasks(id);
    }
}
