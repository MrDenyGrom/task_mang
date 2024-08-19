package com.example.taskmanagement.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;

    @OneToMany(mappedBy = "author")
    private Set<Task> authorTasks;

    @OneToMany(mappedBy = "assignee")
    private Set<Task> assignedTasks;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Task> getAuthorTasks() {
        return authorTasks;
    }

    public void setAuthorTasks(Set<Task> authorTasks) {
        this.authorTasks = authorTasks;
    }

    public Set<Task> getAssignedTasks() {
        return assignedTasks;
    }

    public void setAssignedTasks(Set<Task> assignedTasks) {
        this.assignedTasks = assignedTasks;
    }
}
