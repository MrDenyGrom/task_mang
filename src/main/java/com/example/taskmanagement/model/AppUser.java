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

    public void addAuthorTask(Task task) {
        authorTasks.add(task);
        task.setAuthor(this);
    }

    public void removeAuthorTask(Task task) {
        authorTasks.remove(task);
        task.setAuthor(null);
    }

    public void addAssignedTask(Task task) {
        assignedTasks.add(task);
        task.setAssignee(this);
    }

    public void removeAssignedTask(Task task) {
        assignedTasks.remove(task);
        task.setAssignee(null);
    }

}
