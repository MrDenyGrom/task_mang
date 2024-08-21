package com.example.taskmanagement.dto;

import com.example.taskmanagement.model.Priority;
import com.example.taskmanagement.model.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class TaskDto {

    private Long id;

    @NotBlank(message = "Title is required")
    private String title;

    private String description;

    @NotNull(message = "Status is required")
    private Status status;

    @NotNull(message = "Priority is required")
    private Priority priority;

    @NotNull(message = "Author ID is required")
    private Long authorId;

    @NotNull(message = "Assignee ID is required")
    private Long assigneeId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank(message = "Title is required") String getTitle() {
        return title;
    }

    public void setTitle(@NotBlank(message = "Title is required") String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public @NotNull(message = "Status is required") Status getStatus() {
        return status;
    }

    public void setStatus(@NotNull(message = "Status is required") Status status) {
        this.status = status;
    }

    public @NotNull(message = "Priority is required") Priority getPriority() {
        return priority;
    }

    public void setPriority(@NotNull(message = "Priority is required") Priority priority) {
        this.priority = priority;
    }

    public @NotNull(message = "Author ID is required") Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(@NotNull(message = "Author ID is required") Long authorId) {
        this.authorId = authorId;
    }

    public @NotNull(message = "Assignee ID is required") Long getAssigneeId() {
        return assigneeId;
    }

    public void setAssigneeId(@NotNull(message = "Assignee ID is required") Long assigneeId) {
        this.assigneeId = assigneeId;
    }
}
