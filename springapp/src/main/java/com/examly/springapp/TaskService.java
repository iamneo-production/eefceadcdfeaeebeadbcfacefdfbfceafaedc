package com.examly.springapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    public Task changeTaskStatus(String taskId, String newStatus) {
        Task task = taskRepository.findByTaskId(taskId);
        if (task != null) {
            task.setTaskStatus(newStatus);
            taskRepository.save(task);
        }
        return task;
    }

    public void deleteTask(String taskId) {
        Task task = taskRepository.findByTaskId(taskId);
        if (task != null) {
            taskRepository.delete(task);
        }
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskByTaskId(String taskId) {
        return taskRepository.findByTaskId(taskId);
    }
}
