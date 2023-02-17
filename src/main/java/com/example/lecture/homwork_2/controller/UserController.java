package com.example.lecture.homwork_2.controller;

import com.example.lecture.homwork_2.doamain.User;
import com.example.lecture.homwork_2.service.UserService;
import com.example.lecture.homwork_2.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@ResponseBody
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/user/login")
    public Optional<User> UserLogin(Long userId) {
        return userService.login(userId);
    }

    @PostMapping("/user/join")
    public User userJoin(User user) { //폼으로 가져올거니 modelAtrribute
        return userService.join(user);
    }

    @PostMapping("/user/withdrawal")
    public void userWithdrawal(Long userId) {
        userService.withdrawal(userId);
    }

    @PostMapping("/user/{userId}/modify")
    public void userModify(@PathVariable Long userId, User user) {
        userService.modify(userId, user);
    }
}
