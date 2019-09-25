package com.greenfoxacademy.todo.controllers;

import com.greenfoxacademy.todo.models.ErrorMessage;
import com.greenfoxacademy.todo.models.Todo;
import com.greenfoxacademy.todo.models.TodoUser;
import com.greenfoxacademy.todo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String renderLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam(value = "username") String username, Model model) {
        if (username.isEmpty()) {
            model.addAttribute("errorMessage", new ErrorMessage("Missing username"));
            return "login";
        } else {
            TodoUser user = userService.login(username);
            return "redirect:/profiles/" + user.getId();
        }
    }

    @GetMapping("/profiles/{userId}")
    public String renderIndexPage(@PathVariable Long userId, Model model) {
        model.addAttribute("user", userService.findUser(userId));
        return "index";
    }

}
