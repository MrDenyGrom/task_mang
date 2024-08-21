package com.example.taskmanagement.controller;

import com.example.taskmanagement.dto.CommentDto;
import com.example.taskmanagement.model.Comment;
import com.example.taskmanagement.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/users/comments")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService){
        this.commentService = commentService;
    }

    @GetMapping("/task/{taskId}")
    public ResponseEntity<List<Comment>> getCommentsByTask(@PathVariable Long taskId){
        return ResponseEntity.ok(commentService.getCommentsByTasks(taskId));
    }

    @PostMapping
    public ResponseEntity<Comment> addComment(@RequestBody @Valid CommentDto commentDto) {
        Comment comment = convertToEntity(commentDto);
        return ResponseEntity.ok(commentService.addComment(comment));
    }

    private Comment convertToEntity(CommentDto commentDto) {
        Comment comment = new Comment();
        comment.setId(commentDto.getId());
        comment.setContent(commentDto.getContent());
        return comment;
    }
}
