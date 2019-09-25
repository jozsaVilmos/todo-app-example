package com.greenfoxacademy.todo.controllers;

import com.greenfoxacademy.todo.models.Todo;
import com.greenfoxacademy.todo.models.TodoUser;
import com.greenfoxacademy.todo.service.TodoService;
import com.greenfoxacademy.todo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TodoController {

    private TodoService todoService;
    private UserService userService;

    @Autowired
    public TodoController(TodoService todoService, UserService userService) {
        this.todoService = todoService;
        this.userService = userService;
    }

    @PostMapping("/add-todo")
    public String addTodo(@RequestParam String title, @RequestParam Long userId) {
        TodoUser user = todoService.addTodo(userId, new Todo(title));
        return "redirect:/profiles/" + user.getId();
    }

    @GetMapping("/delete-todo")
    public String deleteTodo(@RequestParam Long userId, @RequestParam Long todoId) {
        TodoUser user = todoService.deleteTodo(userId, todoId);
        return "redirect:/profiles/" + user.getId();
    }

    @GetMapping("/check-todo")
    public String checkTodo(@RequestParam Long todoId, @RequestParam Long userId) {
        TodoUser user = todoService.editTodo(userId, todoService.switchTodo(todoId));
        return "redirect:/profiles/" + user.getId();
    }

    @GetMapping("/edit-todo")
    public String renderEditPage(@RequestParam Long todoId, Model model) {
        model.addAttribute("todo", todoService.findTodo(todoId));
        return "edit";
    }

    @PostMapping("/edit-todo/{userId}")
    public String editTodo(@ModelAttribute Todo todo, @PathVariable Long userId) {
        TodoUser user = userService.findUser(userId);
        todo.setOwner(user);
        todoService.editTodo(userId, todo);
        return "redirect:/profiles/" + userId;
    }

}
