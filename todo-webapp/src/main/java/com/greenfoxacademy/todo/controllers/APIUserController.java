package com.greenfoxacademy.todo.controllers;

import com.greenfoxacademy.todo.models.ErrorMessage;
import com.greenfoxacademy.todo.models.TodoUser;
import com.greenfoxacademy.todo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class APIUserController {

    private UserService userService;

    @Autowired
    public APIUserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity login(@RequestBody TodoUser user) {
        ErrorMessage error = userService.validate(user);
        if (error == null) {
            TodoUser userFromDB = userService.login(user);
            return ResponseEntity.status(200).body(userFromDB);
        } else {
            return ResponseEntity.status(400).body(error);
        }

    }

}
