package com.example.taskmanagement.controller;

import com.example.taskmanagement.model.AppUser;
import com.example.taskmanagement.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<AppUser> registerUser(@RequestBody AppUser user) {
        if (userService.findByEmail(user.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok(userService.saveUser(user));
    }

    @GetMapping("/me")
    public ResponseEntity<AppUser> getCurrentUser(Authentication authentication) {
        String email = authentication.getName();
        Optional<AppUser> user = userService.findByEmail(email);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
