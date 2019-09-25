package com.greenfoxacademy.todo.controllers;

import com.greenfoxacademy.todo.models.Todo;
import com.greenfoxacademy.todo.models.TodoUser;
import com.greenfoxacademy.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users/{userId}/todos")
public class APITodoController {

    private TodoService todoService;

    @Autowired
    public APITodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public ResponseEntity addTodo(@PathVariable Long userId, @RequestBody Todo newTodo) {
        TodoUser user = todoService.addTodo(userId, newTodo);
        return ResponseEntity.status(200).body(user);
    }

    @DeleteMapping("/{todoId}")
    public ResponseEntity deleteTodo(@PathVariable Long userId, @PathVariable Long todoId) {
        TodoUser user = todoService.deleteTodo(userId, todoId);
        return ResponseEntity.status(200).body(user);
    }

    @PutMapping("/{todoId}")
    public ResponseEntity editTodo(@PathVariable Long userId, @PathVariable Long todoId, @RequestBody Todo newTodo) {
        newTodo.setId(todoId);
        TodoUser user = todoService.editTodo(userId, newTodo);
        return ResponseEntity.status(200).body(user);
    }

}
