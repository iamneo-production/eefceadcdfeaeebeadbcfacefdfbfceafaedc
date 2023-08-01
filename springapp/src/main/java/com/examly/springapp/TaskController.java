package com.examly.springapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/saveTask")
    public Task saveTask(@RequestBody Task task) {
        return taskService.saveTask(task);
    }

    @GetMapping("/changeStatus")
    public Task changeTaskStatus(@RequestParam Long id, @RequestParam String status) {
        return taskService.changeTaskStatus(id, status);
    }

    @GetMapping("/deleteTask")
    public void deleteTask(@RequestParam Long id) {
        taskService.deleteTask(id);
    }

    @GetMapping("/alltasks")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/getTask")
    public Task getTaskById(@RequestParam Long id) {
        return taskService.getTaskById(id);
    }

    @GetMapping("/getTaskByHolderName")
    public List<Task> getTaskByHolderName(@RequestParam String holderName) {
        return taskService.getTaskByHolderName(holderName);
    }
}
