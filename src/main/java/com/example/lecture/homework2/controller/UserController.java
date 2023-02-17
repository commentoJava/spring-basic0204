package com.example.lecture.homework2.controller;

import com.example.lecture.homework2.User;
import com.example.lecture.homework2.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> findUserById(@PathVariable Long id) {
        User data = userService.findUserById(id);
        return ResponseEntity.ok().body(data);
    }

    @PostMapping("/user")
    public ResponseEntity<String> registerUser(@ModelAttribute User user){
        User data = userService.registerUser(user);
        return new ResponseEntity<>("ok", HttpStatus.CREATED);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id, User user){
        User data = userService.updateUser(id, user);
        if(data==null){
            return new ResponseEntity<>("error",HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("ok", HttpStatus.CREATED);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return new ResponseEntity<>("ok", HttpStatus.CREATED);
    }
}
