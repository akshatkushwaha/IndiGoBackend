package com.challenge.indigobackend.controller;

import com.challenge.indigobackend.model.Users;
import com.challenge.indigobackend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable Long id) {
        Users user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Users> updateUser(@PathVariable Long id, Users userDetails) {
        Users updatedUser = userService.updateUser(id, userDetails);
        return ResponseEntity.ok(updatedUser);
    }

    @PostMapping
    public ResponseEntity<Users> createUser(@RequestBody Users user) {
        Users newUser = userService.createUser(user);
        return ResponseEntity.ok(newUser);
    }
}
