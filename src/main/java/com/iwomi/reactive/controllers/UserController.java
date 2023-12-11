package com.iwomi.reactive.controllers;

import com.iwomi.reactive.frameworks.UserRepository;
import com.iwomi.reactive.frameworks.data.UserEntity;
import com.iwomi.reactive.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<?> index() {
        List<UserEntity> user = userService.findAll();
        return ResponseEntity.ok().body(user);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody UserEntity userEntity) {
        UserEntity user = userService.create(userEntity);
        return ResponseEntity.ok().body(user);
    }
}
