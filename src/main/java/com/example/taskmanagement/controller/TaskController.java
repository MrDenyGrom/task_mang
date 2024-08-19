package com.example.taskmanagement.controller;

import com.example.taskmanagement.model.Task;
import com.example.taskmanagement.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @GetMapping("/author/{authorId}")
    public ResponseEntity<List<Task>> getTasksByAuthor(@PathVariable Long authorId){
        return ResponseEntity.ok(taskService.getTasksByAuthor((authorId)));
    }

    @GetMapping("/assignee/{assigneeId}")
    public ResponseEntity<List<Task>> getTasksByAssignee(@PathVariable Long assigneeId){
        return ResponseEntity.ok(taskService.getTasksByAssignee(assigneeId));
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody @Valid Task task){
        return ResponseEntity.ok(taskService.createTask(task));
    }

    @PutMapping("/{taskId}")
    public ResponseEntity<Task> updateTask(@PathVariable Long taskId, @RequestBody Task task){
        task.setId(taskId);
        return ResponseEntity.ok(taskService.updateTask(task));
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long taskId){
        taskService.deleteTask(taskId);
        return ResponseEntity.noContent().build();
    }
}
