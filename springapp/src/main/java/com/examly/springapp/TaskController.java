package com.examly.springapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @PostMapping("/saveTask")
    public Task saveTask(@RequestBody Task task) {
        return taskRepository.save(task);
    }

    @GetMapping("/changeStatus")
    public Task changeTaskStatus(@RequestParam Long id, @RequestParam String status) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + id));
        task.setTaskStatus(status);
        return taskRepository.save(task);
    }

    @GetMapping("/deleteTask")
    public void deleteTask(@RequestParam Long id) {
        taskRepository.deleteById(id);
    }

    @GetMapping("/alltasks")
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @GetMapping("/getTask")
    public Task getTaskById(@RequestParam Long id) {
        return taskRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + id));
    }

    @GetMapping("/getTaskByHolderName")
    public List<Task> getTaskByHolderName(@RequestParam String holderName) {
        return taskRepository.findByTaskHolderName(holderName);
    }
}
