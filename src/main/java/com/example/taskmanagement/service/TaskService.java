package com.example.taskmanagement.service;

import com.example.taskmanagement.model.Task;
import com.example.taskmanagement.repository.TaskRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    public List<Task> getTasksByAuthor(Long authorId){
        return taskRepository.findByAuthorId(authorId);
    }

    public List<Task> getTasksByAssignee(Long assigneeId){
        return taskRepository.findByAssigneeId(assigneeId);
    }

    @Transactional
    public Task createTask(Task task) {
        if (task.getId() != null && taskRepository.existsById(task.getId())) {
            throw new IllegalArgumentException("Task with ID " + task.getId() + " already exists");
        }
        return taskRepository.save(task);
    }

    @Transactional
    public Task updateTask(Task task) {
        if (!taskRepository.existsById(task.getId())) {
            throw new IllegalArgumentException("Task with ID " + task.getId() + " does not exist");
        }
        return taskRepository.save(task);
    }

    @Transactional
    public void deleteTask(Long taskId) {
        if (!taskRepository.existsById(taskId)) {
            throw new IllegalArgumentException("Task with ID " + taskId + " does not exist");
        }
        taskRepository.deleteById(taskId);
    }

    public boolean existsById(Long id) {
        return taskRepository.existsById(id);
    }
}
