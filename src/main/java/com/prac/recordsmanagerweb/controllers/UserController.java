package com.prac.recordsmanagerweb.controllers;


import com.prac.recordsmanagerweb.dto.Message;
import com.prac.recordsmanagerweb.dto.UserDto;
import com.prac.recordsmanagerweb.entities.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.prac.recordsmanagerweb.services.UserService;

@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<Message> createUser(@RequestBody UserDto userDto) {

        return userService.createUser(userDto);
    }

    @GetMapping("/users/{username}")
    public User getUserByUsername(@PathVariable String username) {
        return userService.findUser(username);
    }

    @DeleteMapping("/users/{username}")
    public User deleteUser(@PathVariable String username) {
        return userService.deleteUser(username);
    }

    @PostMapping("/login")
    public ResponseEntity<String> authenticateUser() {
        return new ResponseEntity<>("{\"message\" : \"Successful\"}", HttpStatus.OK);
    }
}
