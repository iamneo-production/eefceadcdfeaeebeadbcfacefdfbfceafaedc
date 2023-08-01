package com.examly.springapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Task> saveTask(@RequestBody Task task) {
        Task savedTask = taskService.saveTask(task);
        return new ResponseEntity<>(savedTask, HttpStatus.OK);
    }

    @GetMapping("/changeStatus")
    public ResponseEntity<Task> changeTaskStatus(@RequestParam("id") String id, @RequestParam String newStatus) {
        Task updatedTask = taskService.changeTaskStatus(id, newStatus);
        if (updatedTask != null) {
            return new ResponseEntity<>(updatedTask, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/deleteTask")
    public ResponseEntity<Void> deleteTask(@RequestParam("id") String id) {
        taskService.deleteTask(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/alltasks")
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> tasks = taskService.getAllTasks();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @GetMapping("/getTask")
    public ResponseEntity<Task> getTaskByTaskId(@RequestParam("id") String id) {
        Task task = taskService.getTaskByTaskId(id);
        if (task != null) {
            return new ResponseEntity<>(task, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

