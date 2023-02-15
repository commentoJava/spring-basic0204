package com.example.lecture.homework02.controller;

import com.example.lecture.homework02.domain.Gender;
import com.example.lecture.homework02.domain.User;
import com.example.lecture.homework02.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final UserService userService;

    @PostMapping("/user")
    public ResponseEntity<Result> createUser(@RequestBody @Valid CreateUserRequest userRequest, HttpServletResponse response) {
        User user = new User();
        user.setEmail(userRequest.email);
        user.setAge(userRequest.age);
        user.setUsername(userRequest.username);
        user.setAddress(userRequest.address);
        user.setPhoneNumber(userRequest.phoneNumber);
        user.setGender(userRequest.gender);


        userService.save(user);
        return new ResponseEntity<>(new Result("", "success", response.getStatus()), HttpStatus.CREATED);
    }

    @GetMapping("/users")
    public ResponseEntity<Result> users(HttpServletResponse response) {
        List<User> users = userService.findAll();
        return new ResponseEntity<>(new Result(users, "success", response.getStatus()), HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<Result> user(@PathVariable Long userId) {
        User user = userService.findById(userId);

        if (user == null) {
            return new ResponseEntity<>(new Result("error", "fail", HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(new Result(new UserDto(user), "success", HttpStatus.OK.value()), HttpStatus.OK);
    }

    @PatchMapping("/user/{userId}")
    public ResponseEntity<Result> updateUser(@PathVariable Long userId, @RequestBody UpdateUserRequest updateUserRequest) {
        User finduser = userService.findById(userId);

        if (finduser == null) {
            return new ResponseEntity<>(new Result("error", "fail", HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST);
        }

        finduser.updateUser(updateUserRequest.getEmail(), updateUserRequest.getAddress());

        userService.update(userId, finduser);
        return new ResponseEntity<>(new Result("유저 정보 변경이 완료 되었습니다.", "success", HttpStatus.OK.value()), HttpStatus.OK);
    }

    @DeleteMapping("/user/{userId}")
    public ResponseEntity<Result> deleteUser(@PathVariable Long userId) {

        User finduser = userService.findById(userId);

        if (finduser == null) {
            return new ResponseEntity<>(new Result("error", "fail", HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST);
        }


        userService.delete(userId);
        return new ResponseEntity<>(new Result("", "success", HttpStatus.OK.value()), HttpStatus.OK);
    }


    @Data
    @AllArgsConstructor
    static class CreateUserRequest {
        private String username;
        private String email;

        private int age;
        private String address;
        private String phoneNumber;

        private Gender gender;
    }

    @Data
    @AllArgsConstructor
    static class Result<T> {
        private T data;
        private String message;
        private int statusCode;
    }

    @Data
    static class UpdateUserRequest {
        private String email;

        private String address;

    }

    @Data
    @AllArgsConstructor
    static class UserDto {
        private String username;
        private String email;

        private int age;
        private String address;
        private String phoneNumber;

        private Gender gender;

        public UserDto(User user) {
            username = user.getUsername();
            email = user.getEmail();
            age = user.getAge();
            address = user.getAddress();
            phoneNumber = user.getPhoneNumber();
            gender = user.getGender();
        }

    }

}
