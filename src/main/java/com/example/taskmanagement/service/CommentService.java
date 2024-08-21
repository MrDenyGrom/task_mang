package com.example.taskmanagement.service;

import com.example.taskmanagement.model.Comment;
import com.example.taskmanagement.repository.CommentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository){
        this.commentRepository = commentRepository;
    }

    public List<Comment> getCommentsByTasks(Long taskId){
        return commentRepository.findByTaskId(taskId);
    }

    @Transactional
    public Comment addComment(Comment comment) {
        if (comment.getId() == null || comment.getContent().isEmpty()) {
            throw new IllegalArgumentException("Task ID and comment text must be provided");
        }
        return commentRepository.save(comment);
    }

}
