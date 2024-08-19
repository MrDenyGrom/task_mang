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
    public Task createTask(Task task){
        return taskRepository.save(task);
    }

    @Transactional
    public Task updateTask(Task task){
        return taskRepository.save(task);
    }

    @Transactional
    public void deleteTask(Long taskId){
        taskRepository.deleteById(taskId);
    }
}
