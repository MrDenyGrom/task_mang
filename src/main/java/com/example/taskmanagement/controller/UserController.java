package com.example.taskmanagement.controller;

import com.example.taskmanagement.dto.UserRegistrationDto;
import com.example.taskmanagement.model.AppUser;
import com.example.taskmanagement.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public UserController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody @Valid UserRegistrationDto userDto) {
        if (userService.findByEmail(userDto.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body("User with this email already exists");
        }
        AppUser user = new AppUser();
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        userService.saveUser(user);
        return ResponseEntity.ok("User registered successfully");
    }

    @GetMapping("/users/me")
    public ResponseEntity<AppUser> getCurrentUser(Authentication authentication) {
        String email = authentication.getName();
        Optional<AppUser> user = userService.findByEmail(email);

        return user.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
